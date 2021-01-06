package de.kittybot.kittybot.utils;

import de.kittybot.kittybot.exceptions.MissingConfigValuesException;
import de.kittybot.kittybot.objects.LavalinkNode;
import net.dv8tion.jda.api.utils.data.DataObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class Config{

	public static String DEFAULT_PREFIX;
	public static String BOT_TOKEN;
	public static long BOT_ID;
	public static String BOT_SECRET;
	public static Set<Long> OWNER_IDS;

	public static int BACKEND_PORT;
	public static int PROMETHEUS_PORT;

	public static String HASTEBIN_URL;
	public static String ORIGIN_URL;
	public static String REDIRECT_URL;

	public static String LOG_WEBHOOK_URL;

	public static String SUPPORT_GUILD_INVITE_URL;
	public static String BOT_INVITE_URL;

	public static String TWITCH_CLIENT_ID;
	public static String TWITCH_CLIENT_SECRET;

	public static String SIGNING_KEY;

	public static String TOP_GG_TOKEN;
	public static String DISCORD_EXTREME_LIST_TOKEN;
	public static String DISCORD_BOATS_TOKEN;
	public static String DISCORD_BOTS_TOKEN;
	public static String BOTLIST_SPACE_TOKEN;
	public static String BOTS_FOR_DISCORD_TOKEN;

	public static String DB_HOST;
	public static String DB_PORT;
	public static String DB_DATABASE;
	public static String DB_USER;
	public static String DB_PASSWORD;

	public static Set<LavalinkNode> LAVALINK_NODES;

	private Config(){}

	public static void init(String path) throws IOException, MissingConfigValuesException{
		File config = new File(path);
		if(!config.exists()){
			throw new IOException("Config file not found");
		}
		var json = DataObject.fromJson(Files.readAllBytes(config.toPath()));
		checkMandatoryValues(json, "bot_token", "default_prefix", "owner_ids", "db_host", "db_port", "db_database", "db_user", "db_password", "signing_key", "backend_port", "origin_url", "redirect_url");

		DEFAULT_PREFIX = json.getString("default_prefix", ".");

		BOT_TOKEN = json.getString("bot_token", "");
		if(BOT_TOKEN.isBlank()){
			BOT_ID = -1;
		}
		else{
			BOT_ID = getIdFromToken();
		}
		BOT_SECRET = json.getString("bot_secret", "");

		var ownerIds = json.optArray("owner_ids");
		OWNER_IDS = new HashSet<>();
		if(ownerIds.isPresent()){
			var val = ownerIds.get();
			for(var i = 0; i < val.length(); i++){
				OWNER_IDS.add(val.getLong(i, -1));
			}
		}

		BACKEND_PORT = json.getInt("backend_port", -1);
		PROMETHEUS_PORT = json.getInt("prometheus_port", -1);

		REDIRECT_URL = json.getString("redirect_url", "");
		ORIGIN_URL = json.getString("origin_url", "");
		HASTEBIN_URL = json.getString("hastebin_url", "");

		LOG_WEBHOOK_URL = json.getString("log_webhook_url", "");

		SUPPORT_GUILD_INVITE_URL = json.getString("support_guild_invite_url", "");
		BOT_INVITE_URL = json.getString("bot_invite_url", "");

		TWITCH_CLIENT_ID = json.getString("twitch_client_id", "");
		TWITCH_CLIENT_SECRET = json.getString("twitch_client_secret", "");

		SIGNING_KEY = json.getString("signing_key", "");

		DISCORD_BOTS_TOKEN = json.getString("discord_bots_token", "");
		TOP_GG_TOKEN = json.getString("top_gg_token", "");
		DISCORD_EXTREME_LIST_TOKEN = json.getString("discord_extreme_list_token", "");
		DISCORD_BOATS_TOKEN = json.getString("discord_boats_token", "");
		BOTLIST_SPACE_TOKEN = json.getString("botlist_space_token", "");
		BOTS_FOR_DISCORD_TOKEN = json.getString("bots_for_discord_token", "");

		DB_HOST = json.getString("db_host", "");
		DB_PORT = json.getString("db_port", "");
		DB_DATABASE = json.getString("db_database", "");
		DB_USER = json.getString("db_user", "");
		DB_PASSWORD = json.getString("db_password", "");

		var lavalinkNodes = json.optArray("lavalink_nodes");
		LAVALINK_NODES = new HashSet<>();
		if(lavalinkNodes.isPresent()){
			var val = lavalinkNodes.get();
			for(var i = 0; i < val.length(); i++){
				LAVALINK_NODES.add(new LavalinkNode(val.getObject(i)));
			}
		}
	}

	private static void checkMandatoryValues(DataObject config, String... keys) throws MissingConfigValuesException{
		var missingKeys = new HashSet<String>();
		for(var key : keys){
			if(!config.hasKey(key)){
				missingKeys.add(key);
			}
		}
		if(!missingKeys.isEmpty()){
			throw new MissingConfigValuesException(missingKeys);
		}
	}

	private static long getIdFromToken(){
		return Long.parseLong(
				new String(
						Base64.getDecoder().decode(
								BOT_TOKEN.split("\\.")[0]
						)
				)
		);
	}


}
