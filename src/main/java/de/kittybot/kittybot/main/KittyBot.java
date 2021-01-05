package de.kittybot.kittybot.main;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import de.kittybot.kittybot.exceptions.MissingConfigValuesException;
import de.kittybot.kittybot.managers.*;
import de.kittybot.kittybot.utils.Config;
import de.kittybot.kittybot.utils.ThreadFactoryHelper;
import de.kittybot.kittybot.web.WebService;
import net.dv8tion.jda.api.GatewayEncoding;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.utils.config.ThreadingConfig;
import okhttp3.OkHttpClient;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.concurrent.*;

public class KittyBot{

	private final OkHttpClient httpClient;
	private final JDA jda;
	private final LavalinkManager lavalinkManager;
	private final PrometheusManager prometheusManager;
	private final CommandManager commandManager;
	private final DatabaseManager databaseManager;
	private final InviteManager inviteManager;
	private final InviteRolesManager inviteRolesManager;
	private final StatusManager statusManager;
	private final MessageManager messageManager;
	private final BotListsManager botListManager;
	private final RequestManager requestManager;
	private final StreamAnnouncementManager streamAnnouncementManager;
	private final NotificationManager notificationManager;
	private final DashboardSessionManager dashboardSessionManager;
	private final WebService webService;
	private final ScheduledExecutorService scheduler;
	private final SettingsManager settingsManager;
	private final CommandResponseManager commandResponseManager;
	private final ReactiveMessageManager reactiveMessageManager;
	private final TagManager tagManager;
	private final MusicManager musicManager;
	private final JoinManager joinManager;

	public KittyBot() throws IOException, MissingConfigValuesException, LoginException, InterruptedException{
		Config.init("./config.json");
		this.scheduler = new ScheduledThreadPoolExecutor(2, new ThreadFactoryHelper());
		this.httpClient = new OkHttpClient();
		this.lavalinkManager = new LavalinkManager(this);
		this.databaseManager = new DatabaseManager();
		this.settingsManager = new SettingsManager(this);
		this.commandManager = new CommandManager(this);
		this.commandResponseManager = new CommandResponseManager();
		this.reactiveMessageManager = new ReactiveMessageManager();
		this.joinManager = new JoinManager();
		this.inviteManager = new InviteManager();
		this.inviteRolesManager = new InviteRolesManager(this);
		this.statusManager = new StatusManager(this);
		this.messageManager = new MessageManager();
		this.botListManager = new BotListsManager(this);
		this.requestManager = new RequestManager(this);
		this.tagManager = new TagManager(this);
		this.musicManager = new MusicManager(this);
		this.dashboardSessionManager = new DashboardSessionManager(this);
		this.notificationManager = new NotificationManager(this);
		this.streamAnnouncementManager = new StreamAnnouncementManager(this);
		this.prometheusManager = new PrometheusManager(this);
		this.webService = new WebService(this);

		RestAction.setDefaultFailure(null);
		jda = JDABuilder.create(
				Config.BOT_TOKEN,
				GatewayIntent.GUILD_MEMBERS,
				GatewayIntent.GUILD_VOICE_STATES,
				GatewayIntent.GUILD_MESSAGES,
				GatewayIntent.GUILD_MESSAGE_REACTIONS,
				GatewayIntent.GUILD_EMOJIS,
				GatewayIntent.GUILD_INVITES
		)
				.disableCache(
						CacheFlag.MEMBER_OVERRIDES,
						CacheFlag.ACTIVITY,
						CacheFlag.CLIENT_STATUS,
						CacheFlag.ROLE_TAGS
				)
				.setMemberCachePolicy(MemberCachePolicy.VOICE)
				.setChunkingFilter(ChunkingFilter.NONE)
				.addEventListeners(
						this.joinManager,
						this.settingsManager,
						this.inviteManager,
						this.lavalinkManager.getLavalink(),
						this.commandManager,
						this.statusManager,
						this.messageManager,
						this.botListManager,
						this.commandResponseManager,
						this.prometheusManager,
						this.inviteRolesManager,
						this.musicManager,
						this.notificationManager,
						this.streamAnnouncementManager
				)
				.setHttpClient(this.httpClient)
				.setVoiceDispatchInterceptor(this.lavalinkManager.getLavalink().getVoiceInterceptor())
				.setActivity(Activity.playing("loading..."))
				.setStatus(OnlineStatus.DO_NOT_DISTURB)
				.setEventPool(ThreadingConfig.newScheduler(1, () -> "KittyBot", "Events"), true)
				.setGatewayEncoding(GatewayEncoding.ETF)
				.setBulkDeleteSplittingEnabled(false)
				.build();
	}

	public OkHttpClient getHttpClient(){
		return this.httpClient;
	}

	public JDA getJDA(){
		return this.jda;
	}

	public LavalinkManager getLavalinkManager(){
		return this.lavalinkManager;
	}

	public DashboardSessionManager getDashboardSessionManager(){
		return this.dashboardSessionManager;
	}

	public CommandManager getCommandManager(){
		return this.commandManager;
	}

	public DatabaseManager getDatabaseManager(){
		return this.databaseManager;
	}

	public ScheduledExecutorService getScheduler(){
		return this.scheduler;
	}

	public MessageManager getMessageManager(){
		return this.messageManager;
	}

	public RequestManager getRequestManager(){
		return this.requestManager;
	}

	public WebService getWebService(){
		return this.webService;
	}

	public SettingsManager getGuildSettingsManager(){
		return this.settingsManager;
	}

	public ReactiveMessageManager getReactiveMessageManager(){
		return this.reactiveMessageManager;
	}

	public CommandResponseManager getCommandResponseManager(){
		return this.commandResponseManager;
	}

	public NotificationManager getNotificationManager(){
		return this.notificationManager;
	}

	public InviteManager getInviteManager(){
		return this.inviteManager;
	}

	public TagManager getTagManager(){
		return this.tagManager;
	}

	public MusicManager getMusicManager(){
		return this.musicManager;
	}

	public StreamAnnouncementManager getStreamAnnouncementManager(){
		return this.streamAnnouncementManager;
	}

}
