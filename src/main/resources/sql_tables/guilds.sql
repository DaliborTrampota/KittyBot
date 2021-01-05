CREATE TABLE IF NOT EXISTS guilds(
  guild_id                       bigint PRIMARY KEY NOT NULL,
  announcement_channel_id        bigint NOT NULL default(-1),
  join_message                   text NOT NULL default('Welcome ${user}!'),
  join_messages_enabled          boolean NOT NULL default(false),
  leave_message                  text NOT NULL default('Bye ${user}!'),
  leave_messages_enabled         boolean NOT NULL default(false),
  log_channel_id                 bigint NOT NULL default(-1),
  log_messages_enabled           boolean NOT NULL default(false),
  request_channel_id             bigint NOT NULL default(-1),
  requests_enabled               boolean NOT NULL default(false),
  stream_announcement_channel_id bigint NOT NULL default(-1),
  stream_announcement_message    text NOT NULL default('${user} is now live!'),
  nsfw_enabled                   boolean NOT NULL default(true),
  inactive_role_id               bigint NOT NULL default(-1),
  inactive_duration              interval NOT NULL,
  inactive_role_enabled          boolean NOT NULL default(false),
  dj_role_id                     bigint NOT NULL default(-1),
  snipes_enabled                 boolean NOT NULL default(true)
);
