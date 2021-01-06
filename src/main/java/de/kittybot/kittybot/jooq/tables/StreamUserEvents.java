/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.StreamUserEventsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StreamUserEvents extends TableImpl<StreamUserEventsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.stream_user_events</code>
     */
    public static final StreamUserEvents STREAM_USER_EVENTS = new StreamUserEvents();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StreamUserEventsRecord> getRecordType() {
        return StreamUserEventsRecord.class;
    }

    /**
     * The column <code>public.stream_user_events.id</code>.
     */
    public final TableField<StreamUserEventsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.stream_user_events.stream_user_id</code>.
     */
    public final TableField<StreamUserEventsRecord, Long> STREAM_USER_ID = createField(DSL.name("stream_user_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.stream_user_events.event</code>.
     */
    public final TableField<StreamUserEventsRecord, Integer> EVENT = createField(DSL.name("event"), SQLDataType.INTEGER.nullable(false), this, "");

    private StreamUserEvents(Name alias, Table<StreamUserEventsRecord> aliased) {
        this(alias, aliased, null);
    }

    private StreamUserEvents(Name alias, Table<StreamUserEventsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.stream_user_events</code> table reference
     */
    public StreamUserEvents(String alias) {
        this(DSL.name(alias), STREAM_USER_EVENTS);
    }

    /**
     * Create an aliased <code>public.stream_user_events</code> table reference
     */
    public StreamUserEvents(Name alias) {
        this(alias, STREAM_USER_EVENTS);
    }

    /**
     * Create a <code>public.stream_user_events</code> table reference
     */
    public StreamUserEvents() {
        this(DSL.name("stream_user_events"), null);
    }

    public <O extends Record> StreamUserEvents(Table<O> child, ForeignKey<O, StreamUserEventsRecord> key) {
        super(child, key, STREAM_USER_EVENTS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<StreamUserEventsRecord, Long> getIdentity() {
        return (Identity<StreamUserEventsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<StreamUserEventsRecord> getPrimaryKey() {
        return Keys.STREAM_USER_EVENTS_PKEY;
    }

    @Override
    public List<UniqueKey<StreamUserEventsRecord>> getKeys() {
        return Arrays.<UniqueKey<StreamUserEventsRecord>>asList(Keys.STREAM_USER_EVENTS_PKEY);
    }

    @Override
    public List<ForeignKey<StreamUserEventsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StreamUserEventsRecord, ?>>asList(Keys.STREAM_USER_EVENTS__STREAM_USER_EVENTS_STREAM_USER_ID_FKEY);
    }

    public StreamUsers streamUsers() {
        return new StreamUsers(this, Keys.STREAM_USER_EVENTS__STREAM_USER_EVENTS_STREAM_USER_ID_FKEY);
    }

    @Override
    public StreamUserEvents as(String alias) {
        return new StreamUserEvents(DSL.name(alias), this);
    }

    @Override
    public StreamUserEvents as(Name alias) {
        return new StreamUserEvents(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StreamUserEvents rename(String name) {
        return new StreamUserEvents(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public StreamUserEvents rename(Name name) {
        return new StreamUserEvents(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
