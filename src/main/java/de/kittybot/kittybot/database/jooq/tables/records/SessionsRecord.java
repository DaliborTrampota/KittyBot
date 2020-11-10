/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables.records;


import de.kittybot.kittybot.database.jooq.tables.Sessions;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessionsRecord extends TableRecordImpl<SessionsRecord> implements Record4<String, String, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.sessions.user_id</code>.
     */
    public SessionsRecord setUserId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.user_id</code>.
     */
    public String getUserId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.sessions.access_token</code>.
     */
    public SessionsRecord setAccessToken(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.access_token</code>.
     */
    public String getAccessToken() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.sessions.refresh_token</code>.
     */
    public SessionsRecord setRefreshToken(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.refresh_token</code>.
     */
    public String getRefreshToken() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.sessions.expiration</code>.
     */
    public SessionsRecord setExpiration(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.sessions.expiration</code>.
     */
    public LocalDateTime getExpiration() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Sessions.SESSIONS.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return Sessions.SESSIONS.ACCESS_TOKEN;
    }

    @Override
    public Field<String> field3() {
        return Sessions.SESSIONS.REFRESH_TOKEN;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Sessions.SESSIONS.EXPIRATION;
    }

    @Override
    public String component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getAccessToken();
    }

    @Override
    public String component3() {
        return getRefreshToken();
    }

    @Override
    public LocalDateTime component4() {
        return getExpiration();
    }

    @Override
    public String value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getAccessToken();
    }

    @Override
    public String value3() {
        return getRefreshToken();
    }

    @Override
    public LocalDateTime value4() {
        return getExpiration();
    }

    @Override
    public SessionsRecord value1(String value) {
        setUserId(value);
        return this;
    }

    @Override
    public SessionsRecord value2(String value) {
        setAccessToken(value);
        return this;
    }

    @Override
    public SessionsRecord value3(String value) {
        setRefreshToken(value);
        return this;
    }

    @Override
    public SessionsRecord value4(LocalDateTime value) {
        setExpiration(value);
        return this;
    }

    @Override
    public SessionsRecord values(String value1, String value2, String value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SessionsRecord
     */
    public SessionsRecord() {
        super(Sessions.SESSIONS);
    }

    /**
     * Create a detached, initialised SessionsRecord
     */
    public SessionsRecord(String userId, String accessToken, String refreshToken, LocalDateTime expiration) {
        super(Sessions.SESSIONS);

        setUserId(userId);
        setAccessToken(accessToken);
        setRefreshToken(refreshToken);
        setExpiration(expiration);
    }
}
