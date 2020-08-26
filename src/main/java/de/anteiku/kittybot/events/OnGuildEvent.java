package de.anteiku.kittybot.events;

import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.database.Database;
import de.anteiku.kittybot.objects.BotLists;
import de.anteiku.kittybot.objects.Cache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class OnGuildEvent extends ListenerAdapter{


	@Override
	public void onGuildJoin(GuildJoinEvent event){
		BotLists.update(event.getJDA(), event.getJDA().getGuilds().size());
		Database.registerGuild(event.getGuild());
		Cache.initGuildInviteCache(event.getGuild());
		for(AuditLogEntry entry : event.getGuild().retrieveAuditLogs().cache(false)){
			if(entry.getType() == ActionType.BOT_ADD && entry.getTargetId().equals(event.getJDA().getSelfUser().getId())){
				MessageEmbed embed = new EmbedBuilder().setTitle("Hellowo and thank your for adding me to your Discord Server!").setDescription("To get started you maybe want to set up some self assignable roles. This can be done with `.roles add @role :emote:`. You will need a emote for each role and they should be from your server!\n\n" + "If you want to know my other commands just type ``.commands``.\n" + "To change my prefix use ``.options prefix <your wished prefix>``.\n" + "In case you forgot any command just type ``.cmds`` to get a full list off all my commands!\n\n" + "To report bugs/suggest features either join my [Support Server](https://discord.gg/sD3ABd5), add me on Discord ``Toπ#3141`` or message me on [Twitter](https://twitter.com/TopiSenpai)").setColor(new Color(76, 80, 193)).setThumbnail(event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setFooter(event.getGuild().getName(), event.getGuild().getIconUrl()).setTimestamp(Instant.now()).build();
				var user = entry.getUser();
				if(user != null){
					user.openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage(embed).queue(null,//this should work if the first message got sent,
							failure -> {
								var defaultChannel = event.getGuild().getDefaultChannel();
								if(defaultChannel != null){
									defaultChannel.sendMessage(embed).queue();
								}
							}
					));
				}
				return;//just want to catch the last add loool
			}
		}
		KittyBot.sendToPublicLogChannel(String.format("Hellowo I joined the guild: ``%s`` with owner: ```%s`` and ``%d`` members!\nCurrently I'm in %d guilds!", event.getGuild().getName(), event.getGuild().getOwner().getUser().getAsTag(), event.getGuild().getMemberCount(), event.getJDA().getGuilds().size()));
	}

	@Override
	public void onGuildLeave(GuildLeaveEvent event){
		BotLists.update(event.getJDA(), event.getJDA().getGuilds().size());
		KittyBot.sendToPublicLogChannel(String.format("Helluwu I got kicked from the guild: ``%s``\nCurrently I'm in %d guilds!", event.getGuild().getName(), event.getJDA().getGuilds().size()));
	}

}
