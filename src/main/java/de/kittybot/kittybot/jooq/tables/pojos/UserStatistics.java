/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long          id;
    private final Long          memberId;
    private final Integer       xp;
    private final Integer       level;
    private final Integer       botCalls;
    private final Integer       voiceTime;
    private final Integer       messageCount;
    private final Integer       emoteCount;
    private final LocalDateTime lastActive;

    public UserStatistics(UserStatistics value) {
        this.id = value.id;
        this.memberId = value.memberId;
        this.xp = value.xp;
        this.level = value.level;
        this.botCalls = value.botCalls;
        this.voiceTime = value.voiceTime;
        this.messageCount = value.messageCount;
        this.emoteCount = value.emoteCount;
        this.lastActive = value.lastActive;
    }

    public UserStatistics(
        Long          id,
        Long          memberId,
        Integer       xp,
        Integer       level,
        Integer       botCalls,
        Integer       voiceTime,
        Integer       messageCount,
        Integer       emoteCount,
        LocalDateTime lastActive
    ) {
        this.id = id;
        this.memberId = memberId;
        this.xp = xp;
        this.level = level;
        this.botCalls = botCalls;
        this.voiceTime = voiceTime;
        this.messageCount = messageCount;
        this.emoteCount = emoteCount;
        this.lastActive = lastActive;
    }

    /**
     * Getter for <code>public.user_statistics.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.user_statistics.member_id</code>.
     */
    public Long getMemberId() {
        return this.memberId;
    }

    /**
     * Getter for <code>public.user_statistics.xp</code>.
     */
    public Integer getXp() {
        return this.xp;
    }

    /**
     * Getter for <code>public.user_statistics.level</code>.
     */
    public Integer getLevel() {
        return this.level;
    }

    /**
     * Getter for <code>public.user_statistics.bot_calls</code>.
     */
    public Integer getBotCalls() {
        return this.botCalls;
    }

    /**
     * Getter for <code>public.user_statistics.voice_time</code>.
     */
    public Integer getVoiceTime() {
        return this.voiceTime;
    }

    /**
     * Getter for <code>public.user_statistics.message_count</code>.
     */
    public Integer getMessageCount() {
        return this.messageCount;
    }

    /**
     * Getter for <code>public.user_statistics.emote_count</code>.
     */
    public Integer getEmoteCount() {
        return this.emoteCount;
    }

    /**
     * Getter for <code>public.user_statistics.last_active</code>.
     */
    public LocalDateTime getLastActive() {
        return this.lastActive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserStatistics (");

        sb.append(id);
        sb.append(", ").append(memberId);
        sb.append(", ").append(xp);
        sb.append(", ").append(level);
        sb.append(", ").append(botCalls);
        sb.append(", ").append(voiceTime);
        sb.append(", ").append(messageCount);
        sb.append(", ").append(emoteCount);
        sb.append(", ").append(lastActive);

        sb.append(")");
        return sb.toString();
    }
}
