CREATE TABLE IF NOT EXISTS self_assignable_roles(
  id       BIGSERIAL PRIMARY KEY NOT NULL,
  group_id BIGINT NOT NULL REFERENCES self_assignable_role_groups(id) ON DELETE CASCADE,
  role_id  BIGINT NOT NULL,
  emote_id BIGINT NOT NULL
);
