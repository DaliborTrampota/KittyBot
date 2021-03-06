package de.kittybot.kittybot.objects.music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import de.kittybot.kittybot.modules.MusicModule;
import de.kittybot.kittybot.modules.PaginatorModule;
import de.kittybot.kittybot.modules.SettingsModule;
import de.kittybot.kittybot.objects.enums.Emoji;
import de.kittybot.kittybot.objects.module.Modules;
import de.kittybot.kittybot.slashcommands.context.CommandContext;
import de.kittybot.kittybot.utils.Colors;
import de.kittybot.kittybot.utils.MessageUtils;
import de.kittybot.kittybot.utils.MusicUtils;
import de.kittybot.kittybot.utils.TimeUtils;
import lavalink.client.io.Link;
import lavalink.client.io.jda.JdaLink;
import lavalink.client.player.IPlayer;
import lavalink.client.player.LavalinkPlayer;
import lavalink.client.player.event.PlayerEventListenerAdapter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;

import java.awt.Color;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MusicPlayer extends PlayerEventListenerAdapter{

	public static final Pattern URL_PATTERN = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]?");

	private final Modules modules;
	private final JdaLink link;
	private final LavalinkPlayer player;
	private final LinkedList<AudioTrack> queue;
	private final LinkedList<AudioTrack> history;
	private final long guildId;
	private final long channelId;
	private long controllerMessageId;
	private long lastMessageId;
	private ScheduledFuture<?> future;

	public MusicPlayer(Modules modules, JdaLink link, long guildId, long channelId){
		this.modules = modules;
		this.link = link;
		this.player = link.getPlayer();
		this.player.addListener(this);
		this.guildId = guildId;
		this.channelId = channelId;
		this.queue = new LinkedList<>();
		this.history = new LinkedList<>();
		this.controllerMessageId = -1;
		this.lastMessageId = -2;
		this.future = null;
	}

	public void setVolume(int volume){
		player.getFilters().setVolume((float) volume / 100.0f).commit();
	}

	public void loadItem(CommandContext ctx, String rawQuery, SearchProvider searchProvider){
		final String query;
		if(URL_PATTERN.matcher(rawQuery).matches()){
			query = rawQuery;
		}
		else{
			switch(searchProvider){
				case YOUTUBE:
					query = "ytsearch:" + rawQuery;
					break;
				case SOUNDCLOUD:
					query = "scsearch:" + rawQuery;
					break;
				default:
					query = rawQuery;
			}
		}
		this.link.getRestClient().loadItem(query, new AudioLoadResultHandler(){

			@Override
			public void trackLoaded(AudioTrack track){
				connectToChannel(ctx);
				track.setUserData(ctx.getUser().getIdLong());
				queue(ctx, Collections.singletonList(track));
			}

			@Override
			public void playlistLoaded(AudioPlaylist playlist){
				connectToChannel(ctx);
				if(playlist.isSearchResult()){
					var track = playlist.getSelectedTrack();
					if(track != null){
						track.setUserData(ctx.getUser().getIdLong());
						queue(ctx, Collections.singletonList(track));
					}
					return;
				}
				for(var track : playlist.getTracks()){
					track.setUserData(ctx.getUser().getIdLong());
				}
				queue(ctx, playlist.getTracks());
			}

			@Override
			public void noMatches(){
				ctx.reply("No track found for:\n" + query);
			}

			@Override
			public void loadFailed(FriendlyException e){
				ctx.reply("Failed to load track:\n" + e.getMessage());
			}

		});
	}

	public void connectToChannel(CommandContext ctx){
		var voiceState = ctx.getMember().getVoiceState();
		if(voiceState != null && voiceState.getChannel() != null && this.link.getChannelId() != voiceState.getChannel().getIdLong()){
			this.link.connect(voiceState.getChannel());
		}
	}

	public void queue(CommandContext ctx, List<AudioTrack> tracks){
		for(var track : tracks){
			queue.offer(track);
		}
		if(player.getPlayingTrack() == null){
			player.playTrack(this.queue.poll());
			player.setPaused(false);
		}
		ctx.reply(new EmbedBuilder()
			.setColor(Colors.KITTYBOT_BLUE)
			.setDescription("**Queued " + tracks.size() + " " + MessageUtils.pluralize("track", tracks.size()) + "**\n\n" +
				(tracks.size() == 1 ? MusicUtils.formatTrackWithInfo(tracks.iterator().next()) : "") +
				"\nUse `/queue` to view the queue"
			)
			.setTimestamp(Instant.now())
			.build()
		);
	}

	public void sendTracks(Collection<AudioTrack> tracks, long authorId, String baseMessage){
		var channel = getTextChannel();
		if(channel == null){
			return;
		}
		var trackMessage = new StringBuilder("**").append(baseMessage).append(":**\n");
		var pages = new ArrayList<String>();

		var i = 1;
		for(var track : tracks){
			var formattedTrack = i + ". " + MusicUtils.formatTrackWithInfo(track) + "\n";
			if(trackMessage.length() + formattedTrack.length() >= 2048){
				pages.add(trackMessage.toString());
				trackMessage = new StringBuilder();
			}
			trackMessage.append(formattedTrack);
			i++;
		}
		pages.add(trackMessage.toString());

		this.modules.get(PaginatorModule.class).create(
			channel,
			authorId,
			pages.size(),
			(page, embedBuilder) -> embedBuilder.setColor(Colors.KITTYBOT_BLUE)
				.setDescription(pages.get(page))
				.setTimestamp(Instant.now())
		);
	}

	public TextChannel getTextChannel(){
		var guild = this.modules.getJDA(this.guildId).getGuildById(this.guildId);
		if(guild == null){
			return null;
		}
		return guild.getTextChannelById(this.channelId);
	}

	@Override
	public void onPlayerPause(IPlayer player){
		updateMusicController();
	}

	@Override
	public void onPlayerResume(IPlayer player){
		updateMusicController();
	}

	@Override
	public void onTrackStart(IPlayer player, AudioTrack track){
		sendMusicController();
		cancelDestroy();
	}

	@Override
	public void onTrackEnd(IPlayer player, AudioTrack track, AudioTrackEndReason endReason){
		this.history.push(track);
		if(!endReason.mayStartNext){
			updateMusicController();
			return;
		}
		next();
	}

	public void next(){
		var next = this.queue.poll();
		if(next == null){
			this.player.stopTrack();
			planDestroy();
			return;
		}
		this.player.playTrack(next);
	}

	public void planDestroy(){
		this.player.setPaused(true);
		if(this.future != null){
			return;
		}
		this.future = this.modules.schedule(() -> this.modules.get(MusicModule.class).destroy(this.guildId, -1L), 4, TimeUnit.MINUTES);
	}

	public void updateMusicController(){
		var channel = getTextChannel();
		if(channel == null){
			return;
		}
		if(!channel.getGuild().getSelfMember().hasPermission(channel, Permission.MESSAGE_HISTORY)){
			return;
		}
		channel.editMessageById(this.controllerMessageId, new MessageBuilder().setEmbed(buildMusicController().build()).build()).override(true).queue();
	}

	public EmbedBuilder buildMusicController(){
		var embed = new EmbedBuilder();
		var track = this.player.getPlayingTrack();
		if(this.link.getState() == Link.State.DESTROYED){
			embed.setColor(Color.RED)
				.addField("Disconnected", "", false)
				.addField("Author", "-", true)
				.addField("Length", "-", true)
				.addField("Requested by", "-", true);
		}
		else if(track == null){
			embed.setColor(Color.RED)
				.addField("Waiting", "Nothing to play", false)
				.addField("Author", "-", true)
				.addField("Length", "-", true)
				.addField("Requested by", "-", true);
		}
		else{
			var info = track.getInfo();
			if(this.player.isPaused()){
				embed.setColor(Color.ORANGE)
					.addField("Pausing", Emoji.FORWARD.get() + " " + MusicUtils.formatTrack(track), false);
			}
			else{
				embed.setColor(Color.GREEN)
					.addField("Playing", Emoji.FORWARD.get() + " " + MusicUtils.formatTrack(track), false);
			}
			embed.setThumbnail(getThumbnail(track.getIdentifier(), track.getSourceManager()))
				.addField("Author", info.author, true)
				.addField("Length", TimeUtils.formatDuration(track.getDuration()), true)
				.addField("Requested by", MessageUtils.getUserMention(track.getUserData(Long.class)), true);
		}
		embed.addField("Volume", (int) (this.player.getFilters().getVolume() * 100) + "%", true)
			.setTimestamp(Instant.now());
		return embed;
	}

	public String getThumbnail(String identifier, AudioSourceManager source){
		if(source == null){
			return null;
		}
		var sourceName = source.getSourceName();
		String thumbnail;
		switch(sourceName){
			case "youtube":
				thumbnail = "https://i.ytimg.com/vi/" + identifier + "/hqdefault.jpg";
				break;
			case "twitch":
				thumbnail = "https://static-cdn.jtvnw.net/previews-ttv/live_user_" + identifier + "-440x248.jpg";
				break;
			default:
				thumbnail = null;
				break;
		}
		return thumbnail;
	}

	public void previous(){
		var previous = this.history.pollLast();
		if(previous == null){
			return;
		}
		this.player.playTrack(previous);
	}

	public void sendMusicController(){
		if(this.lastMessageId == this.controllerMessageId){
			updateMusicController();
			return;
		}
		var channel = getTextChannel();
		if(channel == null || !channel.canTalk()){
			return;
		}
		channel.deleteMessageById(this.controllerMessageId).queue();
		var embed = buildMusicController();
		if(!channel.canTalk()){
			return;
		}
		channel.sendMessage(embed.build()).queue(message -> {
			this.controllerMessageId = message.getIdLong();
			if(!channel.getGuild().getSelfMember().hasPermission(channel, Permission.MESSAGE_ADD_REACTION)){
				return;
			}
			message.addReaction(Emoji.VOLUME_DOWN.getStripped()).queue();
			message.addReaction(Emoji.VOLUME_UP.getStripped()).queue();
			message.addReaction(Emoji.ARROW_LEFT.getStripped()).queue();
			message.addReaction(Emoji.PLAY_PAUSE.getStripped()).queue();
			message.addReaction(Emoji.ARROW_RIGHT.getStripped()).queue();
			message.addReaction(Emoji.SHUFFLE.getStripped()).queue();
			message.addReaction(Emoji.X.getStripped()).queue();
		});
	}

	public void cancelDestroy(){
		this.player.setPaused(false);
		if(this.future == null){
			return;
		}
		this.future.cancel(true);
		this.future = null;
	}

	public void pause(){
		player.setPaused(!player.isPaused());
	}

	public boolean shuffle(){
		if(queue.isEmpty()){
			return false;
		}
		Collections.shuffle(this.queue);
		return true;
	}

	public void setPaused(boolean paused){
		player.setPaused(paused);
	}

	public AudioTrack getPlayingTrack(){
		return this.player.getPlayingTrack();
	}

	public JdaLink getLink(){
		return this.link;
	}

	public int removeQueue(int from, int to, Member member){
		var settings = this.modules.get(SettingsModule.class);
		var userId = member.getIdLong();
		var iterator = this.queue.iterator();
		var i = 1;
		var removed = 0;
		while(iterator.hasNext()){
			var track = iterator.next();
			if(i >= from && i <= to && (track.getUserData(Long.class) == userId || settings.hasDJRole(member))){
				iterator.remove();
				removed++;
			}
			i++;
		}
		return removed;
	}

	public long getControllerMessageId(){
		return this.controllerMessageId;
	}

	public LinkedList<AudioTrack> getQueue(){
		return this.queue;
	}

	public LinkedList<AudioTrack> getHistory(){
		return this.history;
	}

	public LavalinkPlayer getPlayer(){
		return this.player;
	}

	public void increaseVolume(int volumeStep){
		var newVol = (int) (this.player.getFilters().getVolume() * 100) + volumeStep;
		if(newVol <= 0){
			newVol = 10;
		}
		if(newVol > 150){
			newVol = 150;
		}
		player.getFilters().setVolume(newVol / 100.0f).commit();
		updateMusicController();
	}

	public void setLastMessageId(long lastMessageId){
		this.lastMessageId = lastMessageId;
	}

	public DataObject toJSON(){
		return DataObject.empty()
			.put("guild_id", Long.toString(this.guildId))
			.put("channel_id", Long.toString(this.channelId))
			.put("queue", tracksToJSON(this.queue))
			.put("history", tracksToJSON(this.history));
	}

	private DataArray tracksToJSON(List<AudioTrack> tracks){
		return DataArray.fromCollection(tracks.stream().map(this::trackToJSON).collect(Collectors.toList()));
	}

	private DataObject trackToJSON(AudioTrack track){
		var info = track.getInfo();
		return DataObject.empty()
			.put("identifier", info.identifier)
			.put("uri", info.uri)
			.put("title", info.title)
			.put("author", info.author)
			.put("length", info.length)
			.put("source_name", track.getSourceManager().getSourceName())
			.put("is_stream", info.isStream);
	}

}
