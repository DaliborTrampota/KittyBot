package de.anteiku.kittybot.commands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import org.apache.commons.collections4.Bag;

import java.util.List;

public interface CommandContext{

	JDA getJDA();

	Guild getGuild();

	TextChannel getChannel();

	Message getMessage();

	String getCommand();

	String[] getArgs();

	User getUser();

	List<User> getMentionedUsers();

	Bag<User> getMentionedUsersBag();

	Member getMember();

	List<TextChannel> getMentionedChannels();

	Bag<TextChannel> getMentionedChannelsBag();

	List<Role> getMentionedRoles();

	Bag<Role> getMentionedRolesBag();

}