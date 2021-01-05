/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq;


import de.kittybot.kittybot.jooq.tables.BotDisabledChannels;
import de.kittybot.kittybot.jooq.tables.BotIgnoredUsers;
import de.kittybot.kittybot.jooq.tables.GuildInviteRoles;
import de.kittybot.kittybot.jooq.tables.GuildInvites;
import de.kittybot.kittybot.jooq.tables.GuildPrefixes;
import de.kittybot.kittybot.jooq.tables.GuildTags;
import de.kittybot.kittybot.jooq.tables.Guilds;
import de.kittybot.kittybot.jooq.tables.Notifications;
import de.kittybot.kittybot.jooq.tables.ReactiveMessages;
import de.kittybot.kittybot.jooq.tables.Requests;
import de.kittybot.kittybot.jooq.tables.SelfAssignableRoleGroups;
import de.kittybot.kittybot.jooq.tables.SelfAssignableRoles;
import de.kittybot.kittybot.jooq.tables.Sessions;
import de.kittybot.kittybot.jooq.tables.SnipeDisabledChannels;
import de.kittybot.kittybot.jooq.tables.StreamUserEvents;
import de.kittybot.kittybot.jooq.tables.StreamUsers;
import de.kittybot.kittybot.jooq.tables.UserStatistics;
import de.kittybot.kittybot.jooq.tables.records.BotDisabledChannelsRecord;
import de.kittybot.kittybot.jooq.tables.records.BotIgnoredUsersRecord;
import de.kittybot.kittybot.jooq.tables.records.GuildInviteRolesRecord;
import de.kittybot.kittybot.jooq.tables.records.GuildInvitesRecord;
import de.kittybot.kittybot.jooq.tables.records.GuildPrefixesRecord;
import de.kittybot.kittybot.jooq.tables.records.GuildTagsRecord;
import de.kittybot.kittybot.jooq.tables.records.GuildsRecord;
import de.kittybot.kittybot.jooq.tables.records.NotificationsRecord;
import de.kittybot.kittybot.jooq.tables.records.ReactiveMessagesRecord;
import de.kittybot.kittybot.jooq.tables.records.RequestsRecord;
import de.kittybot.kittybot.jooq.tables.records.SelfAssignableRoleGroupsRecord;
import de.kittybot.kittybot.jooq.tables.records.SelfAssignableRolesRecord;
import de.kittybot.kittybot.jooq.tables.records.SessionsRecord;
import de.kittybot.kittybot.jooq.tables.records.SnipeDisabledChannelsRecord;
import de.kittybot.kittybot.jooq.tables.records.StreamUserEventsRecord;
import de.kittybot.kittybot.jooq.tables.records.StreamUsersRecord;
import de.kittybot.kittybot.jooq.tables.records.UserStatisticsRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BotDisabledChannelsRecord> BOT_DISABLED_CHANNELS_PKEY = Internal.createUniqueKey(BotDisabledChannels.BOT_DISABLED_CHANNELS, DSL.name("bot_disabled_channels_pkey"), new TableField[] { BotDisabledChannels.BOT_DISABLED_CHANNELS.BOT_DISABLED_CHANNEL_ID }, true);
    public static final UniqueKey<BotIgnoredUsersRecord> BOT_IGNORED_USERS_PKEY = Internal.createUniqueKey(BotIgnoredUsers.BOT_IGNORED_USERS, DSL.name("bot_ignored_users_pkey"), new TableField[] { BotIgnoredUsers.BOT_IGNORED_USERS.BOT_IGNORED_USER_ID }, true);
    public static final UniqueKey<GuildInviteRolesRecord> GUILD_INVITE_ROLES_PKEY = Internal.createUniqueKey(GuildInviteRoles.GUILD_INVITE_ROLES, DSL.name("guild_invite_roles_pkey"), new TableField[] { GuildInviteRoles.GUILD_INVITE_ROLES.GUILD_INVITE_ROLE_ID }, true);
    public static final UniqueKey<GuildInvitesRecord> GUILD_INVITES_CODE_KEY = Internal.createUniqueKey(GuildInvites.GUILD_INVITES, DSL.name("guild_invites_code_key"), new TableField[] { GuildInvites.GUILD_INVITES.CODE }, true);
    public static final UniqueKey<GuildInvitesRecord> GUILD_INVITES_PKEY = Internal.createUniqueKey(GuildInvites.GUILD_INVITES, DSL.name("guild_invites_pkey"), new TableField[] { GuildInvites.GUILD_INVITES.GUILD_INVITE_ID }, true);
    public static final UniqueKey<GuildPrefixesRecord> GUILD_PREFIXES_GUILD_ID_KEY = Internal.createUniqueKey(GuildPrefixes.GUILD_PREFIXES, DSL.name("guild_prefixes_guild_id_key"), new TableField[] { GuildPrefixes.GUILD_PREFIXES.GUILD_ID }, true);
    public static final UniqueKey<GuildPrefixesRecord> GUILD_PREFIXES_PKEY = Internal.createUniqueKey(GuildPrefixes.GUILD_PREFIXES, DSL.name("guild_prefixes_pkey"), new TableField[] { GuildPrefixes.GUILD_PREFIXES.GUILD_PREFIX_ID }, true);
    public static final UniqueKey<GuildPrefixesRecord> GUILD_PREFIXES_PREFIX_KEY = Internal.createUniqueKey(GuildPrefixes.GUILD_PREFIXES, DSL.name("guild_prefixes_prefix_key"), new TableField[] { GuildPrefixes.GUILD_PREFIXES.PREFIX }, true);
    public static final UniqueKey<GuildTagsRecord> GUILD_TAGS_GUILD_ID_KEY = Internal.createUniqueKey(GuildTags.GUILD_TAGS, DSL.name("guild_tags_guild_id_key"), new TableField[] { GuildTags.GUILD_TAGS.GUILD_ID }, true);
    public static final UniqueKey<GuildTagsRecord> GUILD_TAGS_NAME_KEY = Internal.createUniqueKey(GuildTags.GUILD_TAGS, DSL.name("guild_tags_name_key"), new TableField[] { GuildTags.GUILD_TAGS.NAME }, true);
    public static final UniqueKey<GuildTagsRecord> GUILD_TAGS_PKEY = Internal.createUniqueKey(GuildTags.GUILD_TAGS, DSL.name("guild_tags_pkey"), new TableField[] { GuildTags.GUILD_TAGS.TAG_ID }, true);
    public static final UniqueKey<GuildsRecord> GUILDS_PKEY = Internal.createUniqueKey(Guilds.GUILDS, DSL.name("guilds_pkey"), new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final UniqueKey<NotificationsRecord> NOTIFICATIONS_PKEY = Internal.createUniqueKey(Notifications.NOTIFICATIONS, DSL.name("notifications_pkey"), new TableField[] { Notifications.NOTIFICATIONS.NOTIFICATION_ID }, true);
    public static final UniqueKey<ReactiveMessagesRecord> REACTIVE_MESSAGES_PKEY = Internal.createUniqueKey(ReactiveMessages.REACTIVE_MESSAGES, DSL.name("reactive_messages_pkey"), new TableField[] { ReactiveMessages.REACTIVE_MESSAGES.REACTIVE_MESSAGE_ID }, true);
    public static final UniqueKey<RequestsRecord> REQUESTS_PKEY = Internal.createUniqueKey(Requests.REQUESTS, DSL.name("requests_pkey"), new TableField[] { Requests.REQUESTS.REQUEST_ID }, true);
    public static final UniqueKey<SelfAssignableRoleGroupsRecord> SELF_ASSIGNABLE_ROLE_GROUPS_PKEY = Internal.createUniqueKey(SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS, DSL.name("self_assignable_role_groups_pkey"), new TableField[] { SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS.SELF_ASSIGNABLE_ROLE_GROUP_ID }, true);
    public static final UniqueKey<SelfAssignableRolesRecord> SELF_ASSIGNABLE_ROLES_PKEY = Internal.createUniqueKey(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES, DSL.name("self_assignable_roles_pkey"), new TableField[] { SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.SELF_ASSIGNABLE_ROLE_ID }, true);
    public static final UniqueKey<SessionsRecord> SESSIONS_PKEY = Internal.createUniqueKey(Sessions.SESSIONS, DSL.name("sessions_pkey"), new TableField[] { Sessions.SESSIONS.USER_ID }, true);
    public static final UniqueKey<SnipeDisabledChannelsRecord> SNIPE_DISABLED_CHANNELS_PKEY = Internal.createUniqueKey(SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS, DSL.name("snipe_disabled_channels_pkey"), new TableField[] { SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS.SNIPE_DISABLED_CHANNEL_ID }, true);
    public static final UniqueKey<StreamUserEventsRecord> STREAM_USER_EVENTS_PKEY = Internal.createUniqueKey(StreamUserEvents.STREAM_USER_EVENTS, DSL.name("stream_user_events_pkey"), new TableField[] { StreamUserEvents.STREAM_USER_EVENTS.STEAM_USER_EVENT_ID }, true);
    public static final UniqueKey<StreamUsersRecord> STREAM_USERS_PKEY = Internal.createUniqueKey(StreamUsers.STREAM_USERS, DSL.name("stream_users_pkey"), new TableField[] { StreamUsers.STREAM_USERS.STREAM_USER_ID }, true);
    public static final UniqueKey<UserStatisticsRecord> USER_STATISTICS_PKEY = Internal.createUniqueKey(UserStatistics.USER_STATISTICS, DSL.name("user_statistics_pkey"), new TableField[] { UserStatistics.USER_STATISTICS.USER_STATISTIC_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BotDisabledChannelsRecord, GuildsRecord> BOT_DISABLED_CHANNELS__BOT_DISABLED_CHANNELS_GUILD_ID_FKEY = Internal.createForeignKey(BotDisabledChannels.BOT_DISABLED_CHANNELS, DSL.name("bot_disabled_channels_guild_id_fkey"), new TableField[] { BotDisabledChannels.BOT_DISABLED_CHANNELS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<BotIgnoredUsersRecord, GuildsRecord> BOT_IGNORED_USERS__BOT_IGNORED_USERS_GUILD_ID_FKEY = Internal.createForeignKey(BotIgnoredUsers.BOT_IGNORED_USERS, DSL.name("bot_ignored_users_guild_id_fkey"), new TableField[] { BotIgnoredUsers.BOT_IGNORED_USERS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<GuildInviteRolesRecord, GuildInvitesRecord> GUILD_INVITE_ROLES__GUILD_INVITE_ROLES_GUILD_INVITE_ID_FKEY = Internal.createForeignKey(GuildInviteRoles.GUILD_INVITE_ROLES, DSL.name("guild_invite_roles_guild_invite_id_fkey"), new TableField[] { GuildInviteRoles.GUILD_INVITE_ROLES.GUILD_INVITE_ID }, Keys.GUILD_INVITES_PKEY, new TableField[] { GuildInvites.GUILD_INVITES.GUILD_INVITE_ID }, true);
    public static final ForeignKey<GuildInvitesRecord, GuildsRecord> GUILD_INVITES__GUILD_INVITES_GUILD_ID_FKEY = Internal.createForeignKey(GuildInvites.GUILD_INVITES, DSL.name("guild_invites_guild_id_fkey"), new TableField[] { GuildInvites.GUILD_INVITES.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<GuildPrefixesRecord, GuildsRecord> GUILD_PREFIXES__GUILD_PREFIXES_GUILD_ID_FKEY = Internal.createForeignKey(GuildPrefixes.GUILD_PREFIXES, DSL.name("guild_prefixes_guild_id_fkey"), new TableField[] { GuildPrefixes.GUILD_PREFIXES.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<GuildTagsRecord, GuildsRecord> GUILD_TAGS__GUILD_TAGS_GUILD_ID_FKEY = Internal.createForeignKey(GuildTags.GUILD_TAGS, DSL.name("guild_tags_guild_id_fkey"), new TableField[] { GuildTags.GUILD_TAGS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<NotificationsRecord, GuildsRecord> NOTIFICATIONS__NOTIFICATIONS_GUILD_ID_FKEY = Internal.createForeignKey(Notifications.NOTIFICATIONS, DSL.name("notifications_guild_id_fkey"), new TableField[] { Notifications.NOTIFICATIONS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<ReactiveMessagesRecord, GuildsRecord> REACTIVE_MESSAGES__REACTIVE_MESSAGES_GUILD_ID_FKEY = Internal.createForeignKey(ReactiveMessages.REACTIVE_MESSAGES, DSL.name("reactive_messages_guild_id_fkey"), new TableField[] { ReactiveMessages.REACTIVE_MESSAGES.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<RequestsRecord, GuildsRecord> REQUESTS__REQUESTS_GUILD_ID_FKEY = Internal.createForeignKey(Requests.REQUESTS, DSL.name("requests_guild_id_fkey"), new TableField[] { Requests.REQUESTS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<SelfAssignableRoleGroupsRecord, GuildsRecord> SELF_ASSIGNABLE_ROLE_GROUPS__SELF_ASSIGNABLE_ROLE_GROUPS_GUILD_ID_FKEY = Internal.createForeignKey(SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS, DSL.name("self_assignable_role_groups_guild_id_fkey"), new TableField[] { SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<SelfAssignableRolesRecord, SelfAssignableRoleGroupsRecord> SELF_ASSIGNABLE_ROLES__SELF_ASSIGNABLE_ROLES_GROUP_ID_FKEY = Internal.createForeignKey(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES, DSL.name("self_assignable_roles_group_id_fkey"), new TableField[] { SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.GROUP_ID }, Keys.SELF_ASSIGNABLE_ROLE_GROUPS_PKEY, new TableField[] { SelfAssignableRoleGroups.SELF_ASSIGNABLE_ROLE_GROUPS.SELF_ASSIGNABLE_ROLE_GROUP_ID }, true);
    public static final ForeignKey<SelfAssignableRolesRecord, GuildsRecord> SELF_ASSIGNABLE_ROLES__SELF_ASSIGNABLE_ROLES_GUILD_ID_FKEY = Internal.createForeignKey(SelfAssignableRoles.SELF_ASSIGNABLE_ROLES, DSL.name("self_assignable_roles_guild_id_fkey"), new TableField[] { SelfAssignableRoles.SELF_ASSIGNABLE_ROLES.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<SnipeDisabledChannelsRecord, GuildsRecord> SNIPE_DISABLED_CHANNELS__SNIPE_DISABLED_CHANNELS_GUILD_ID_FKEY = Internal.createForeignKey(SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS, DSL.name("snipe_disabled_channels_guild_id_fkey"), new TableField[] { SnipeDisabledChannels.SNIPE_DISABLED_CHANNELS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<StreamUserEventsRecord, StreamUsersRecord> STREAM_USER_EVENTS__STREAM_USER_EVENTS_STREAM_USER_ID_FKEY = Internal.createForeignKey(StreamUserEvents.STREAM_USER_EVENTS, DSL.name("stream_user_events_stream_user_id_fkey"), new TableField[] { StreamUserEvents.STREAM_USER_EVENTS.STREAM_USER_ID }, Keys.STREAM_USERS_PKEY, new TableField[] { StreamUsers.STREAM_USERS.STREAM_USER_ID }, true);
    public static final ForeignKey<StreamUsersRecord, GuildsRecord> STREAM_USERS__STREAM_USERS_GUILD_ID_FKEY = Internal.createForeignKey(StreamUsers.STREAM_USERS, DSL.name("stream_users_guild_id_fkey"), new TableField[] { StreamUsers.STREAM_USERS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<UserStatisticsRecord, GuildsRecord> USER_STATISTICS__USER_STATISTICS_GUILD_ID_FKEY = Internal.createForeignKey(UserStatistics.USER_STATISTICS, DSL.name("user_statistics_guild_id_fkey"), new TableField[] { UserStatistics.USER_STATISTICS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
}
