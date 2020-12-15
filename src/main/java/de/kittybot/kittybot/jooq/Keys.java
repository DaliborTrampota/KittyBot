/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq;


import de.kittybot.kittybot.jooq.tables.*;
import de.kittybot.kittybot.jooq.tables.records.*;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys{

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<BotDisabledChannelsRecord> BOT_DISABLED_CHANNELS_PKEY = Internal.createUniqueKey(BotDisabledChannels.BOT_DISABLED_CHANNELS, DSL.name("bot_disabled_channels_pkey"), new TableField[]{BotDisabledChannels.BOT_DISABLED_CHANNELS.GUILD_ID, BotDisabledChannels.BOT_DISABLED_CHANNELS.CHANNEL_ID}, true);
	public static final UniqueKey<GuildsRecord> GUILDS_PKEY = Internal.createUniqueKey(Guilds.GUILDS, DSL.name("guilds_pkey"), new TableField[]{Guilds.GUILDS.GUILD_ID}, true);
	public static final UniqueKey<ReactiveMessagesRecord> REACTIVE_MESSAGES_PKEY = Internal.createUniqueKey(ReactiveMessages.REACTIVE_MESSAGES, DSL.name("reactive_messages_pkey"), new TableField[]{ReactiveMessages.REACTIVE_MESSAGES.GUILD_ID, ReactiveMessages.REACTIVE_MESSAGES.CHANNEL_ID, ReactiveMessages.REACTIVE_MESSAGES.MESSAGE_ID, ReactiveMessages.REACTIVE_MESSAGES.USER_ID}, true);
	public static final UniqueKey<SelfAssignableRolesRecord> SELF_ASSIGNABLE_ROLES_PKEY = Internal.createUniqueKey(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES, DSL.name("self_assignable_roles_pkey"), new TableField[]{SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.ROLE_ID, SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.GUILD_ID}, true);
	public static final UniqueKey<SessionsRecord> SESSIONS_PKEY = Internal.createUniqueKey(Sessions.SESSIONS, DSL.name("sessions_pkey"), new TableField[]{Sessions.SESSIONS.USER_ID}, true);
	public static final UniqueKey<SnipeDisabledChannelsRecord> SNIPE_DISABLED_CHANNELS_PKEY = Internal.createUniqueKey(SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS, DSL.name("snipe_disabled_channels_pkey"), new TableField[]{SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS.GUILD_ID, SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS.CHANNEL_ID}, true);

}
