/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.BotDisabledChannelsRecord;

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
public class BotDisabledChannels extends TableImpl<BotDisabledChannelsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.bot_disabled_channels</code>
     */
    public static final BotDisabledChannels BOT_DISABLED_CHANNELS = new BotDisabledChannels();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BotDisabledChannelsRecord> getRecordType() {
        return BotDisabledChannelsRecord.class;
    }

    /**
     * The column <code>public.bot_disabled_channels.id</code>.
     */
    public final TableField<BotDisabledChannelsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.bot_disabled_channels.guild_id</code>.
     */
    public final TableField<BotDisabledChannelsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.bot_disabled_channels.channel_id</code>.
     */
    public final TableField<BotDisabledChannelsRecord, Long> CHANNEL_ID = createField(DSL.name("channel_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private BotDisabledChannels(Name alias, Table<BotDisabledChannelsRecord> aliased) {
        this(alias, aliased, null);
    }

    private BotDisabledChannels(Name alias, Table<BotDisabledChannelsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.bot_disabled_channels</code> table reference
     */
    public BotDisabledChannels(String alias) {
        this(DSL.name(alias), BOT_DISABLED_CHANNELS);
    }

    /**
     * Create an aliased <code>public.bot_disabled_channels</code> table reference
     */
    public BotDisabledChannels(Name alias) {
        this(alias, BOT_DISABLED_CHANNELS);
    }

    /**
     * Create a <code>public.bot_disabled_channels</code> table reference
     */
    public BotDisabledChannels() {
        this(DSL.name("bot_disabled_channels"), null);
    }

    public <O extends Record> BotDisabledChannels(Table<O> child, ForeignKey<O, BotDisabledChannelsRecord> key) {
        super(child, key, BOT_DISABLED_CHANNELS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<BotDisabledChannelsRecord, Long> getIdentity() {
        return (Identity<BotDisabledChannelsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<BotDisabledChannelsRecord> getPrimaryKey() {
        return Keys.BOT_DISABLED_CHANNELS_PKEY;
    }

    @Override
    public List<UniqueKey<BotDisabledChannelsRecord>> getKeys() {
        return Arrays.<UniqueKey<BotDisabledChannelsRecord>>asList(Keys.BOT_DISABLED_CHANNELS_PKEY, Keys.BOT_DISABLED_CHANNELS_GUILD_ID_CHANNEL_ID_KEY, Keys.BOT_DISABLED_CHANNELS_CHANNEL_ID_KEY);
    }

    @Override
    public List<ForeignKey<BotDisabledChannelsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BotDisabledChannelsRecord, ?>>asList(Keys.BOT_DISABLED_CHANNELS__BOT_DISABLED_CHANNELS_GUILD_ID_FKEY);
    }

    public Guilds guilds() {
        return new Guilds(this, Keys.BOT_DISABLED_CHANNELS__BOT_DISABLED_CHANNELS_GUILD_ID_FKEY);
    }

    @Override
    public BotDisabledChannels as(String alias) {
        return new BotDisabledChannels(DSL.name(alias), this);
    }

    @Override
    public BotDisabledChannels as(Name alias) {
        return new BotDisabledChannels(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BotDisabledChannels rename(String name) {
        return new BotDisabledChannels(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BotDisabledChannels rename(Name name) {
        return new BotDisabledChannels(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
