/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.RequestsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
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
public class Requests extends TableImpl<RequestsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.requests</code>
     */
    public static final Requests REQUESTS = new Requests();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RequestsRecord> getRecordType() {
        return RequestsRecord.class;
    }

    /**
     * The column <code>public.requests.id</code>.
     */
    public final TableField<RequestsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.requests.guild_id</code>.
     */
    public final TableField<RequestsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.requests.user_id</code>.
     */
    public final TableField<RequestsRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.requests.title</code>.
     */
    public final TableField<RequestsRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>public.requests.body</code>.
     */
    public final TableField<RequestsRecord, String> BODY = createField(DSL.name("body"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.requests.answered</code>.
     */
    public final TableField<RequestsRecord, Boolean> ANSWERED = createField(DSL.name("answered"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.requests.accepted</code>.
     */
    public final TableField<RequestsRecord, Boolean> ACCEPTED = createField(DSL.name("accepted"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.requests.creation_at</code>.
     */
    public final TableField<RequestsRecord, LocalDateTime> CREATION_AT = createField(DSL.name("creation_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    private Requests(Name alias, Table<RequestsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Requests(Name alias, Table<RequestsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.requests</code> table reference
     */
    public Requests(String alias) {
        this(DSL.name(alias), REQUESTS);
    }

    /**
     * Create an aliased <code>public.requests</code> table reference
     */
    public Requests(Name alias) {
        this(alias, REQUESTS);
    }

    /**
     * Create a <code>public.requests</code> table reference
     */
    public Requests() {
        this(DSL.name("requests"), null);
    }

    public <O extends Record> Requests(Table<O> child, ForeignKey<O, RequestsRecord> key) {
        super(child, key, REQUESTS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<RequestsRecord, Long> getIdentity() {
        return (Identity<RequestsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<RequestsRecord> getPrimaryKey() {
        return Keys.REQUESTS_PKEY;
    }

    @Override
    public List<UniqueKey<RequestsRecord>> getKeys() {
        return Arrays.<UniqueKey<RequestsRecord>>asList(Keys.REQUESTS_PKEY);
    }

    @Override
    public List<ForeignKey<RequestsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RequestsRecord, ?>>asList(Keys.REQUESTS__REQUESTS_GUILD_ID_FKEY);
    }

    public Guilds guilds() {
        return new Guilds(this, Keys.REQUESTS__REQUESTS_GUILD_ID_FKEY);
    }

    @Override
    public Requests as(String alias) {
        return new Requests(DSL.name(alias), this);
    }

    @Override
    public Requests as(Name alias) {
        return new Requests(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Requests rename(String name) {
        return new Requests(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Requests rename(Name name) {
        return new Requests(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Long, String, String, Boolean, Boolean, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
