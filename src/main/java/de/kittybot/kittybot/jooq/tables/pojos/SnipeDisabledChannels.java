/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SnipeDisabledChannels implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long guildId;
    private final Long channelId;

    public SnipeDisabledChannels(SnipeDisabledChannels value) {
        this.guildId = value.guildId;
        this.channelId = value.channelId;
    }

    public SnipeDisabledChannels(
        Long guildId,
        Long channelId
    ) {
        this.guildId = guildId;
        this.channelId = channelId;
    }

    /**
     * Getter for <code>public.snipe_disabled_channels.guild_id</code>.
     */
    public Long getGuildId() {
        return this.guildId;
    }

    /**
     * Getter for <code>public.snipe_disabled_channels.channel_id</code>.
     */
    public Long getChannelId() {
        return this.channelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SnipeDisabledChannels (");

        sb.append(guildId);
        sb.append(", ").append(channelId);

        sb.append(")");
        return sb.toString();
    }
}
