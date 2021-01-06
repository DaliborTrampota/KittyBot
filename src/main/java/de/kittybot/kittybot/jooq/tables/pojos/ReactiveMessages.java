/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReactiveMessages implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long   id;
    private final Long   memberId;
    private final Long   channelId;
    private final Long   messageId;
    private final String commandPath;
    private final Long   allowed;

    public ReactiveMessages(ReactiveMessages value) {
        this.id = value.id;
        this.memberId = value.memberId;
        this.channelId = value.channelId;
        this.messageId = value.messageId;
        this.commandPath = value.commandPath;
        this.allowed = value.allowed;
    }

    public ReactiveMessages(
        Long   id,
        Long   memberId,
        Long   channelId,
        Long   messageId,
        String commandPath,
        Long   allowed
    ) {
        this.id = id;
        this.memberId = memberId;
        this.channelId = channelId;
        this.messageId = messageId;
        this.commandPath = commandPath;
        this.allowed = allowed;
    }

    /**
     * Getter for <code>public.reactive_messages.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.reactive_messages.member_id</code>.
     */
    public Long getMemberId() {
        return this.memberId;
    }

    /**
     * Getter for <code>public.reactive_messages.channel_id</code>.
     */
    public Long getChannelId() {
        return this.channelId;
    }

    /**
     * Getter for <code>public.reactive_messages.message_id</code>.
     */
    public Long getMessageId() {
        return this.messageId;
    }

    /**
     * Getter for <code>public.reactive_messages.command_path</code>.
     */
    public String getCommandPath() {
        return this.commandPath;
    }

    /**
     * Getter for <code>public.reactive_messages.allowed</code>.
     */
    public Long getAllowed() {
        return this.allowed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ReactiveMessages (");

        sb.append(id);
        sb.append(", ").append(memberId);
        sb.append(", ").append(channelId);
        sb.append(", ").append(messageId);
        sb.append(", ").append(commandPath);
        sb.append(", ").append(allowed);

        sb.append(")");
        return sb.toString();
    }
}
