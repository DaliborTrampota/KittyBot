/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildInvites implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long   guildInviteId;
    private final Long   guildId;
    private final String code;

    public GuildInvites(GuildInvites value) {
        this.guildInviteId = value.guildInviteId;
        this.guildId = value.guildId;
        this.code = value.code;
    }

    public GuildInvites(
        Long   guildInviteId,
        Long   guildId,
        String code
    ) {
        this.guildInviteId = guildInviteId;
        this.guildId = guildId;
        this.code = code;
    }

    /**
     * Getter for <code>public.guild_invites.guild_invite_id</code>.
     */
    public Long getGuildInviteId() {
        return this.guildInviteId;
    }

    /**
     * Getter for <code>public.guild_invites.guild_id</code>.
     */
    public Long getGuildId() {
        return this.guildId;
    }

    /**
     * Getter for <code>public.guild_invites.code</code>.
     */
    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GuildInvites (");

        sb.append(guildInviteId);
        sb.append(", ").append(guildId);
        sb.append(", ").append(code);

        sb.append(")");
        return sb.toString();
    }
}
