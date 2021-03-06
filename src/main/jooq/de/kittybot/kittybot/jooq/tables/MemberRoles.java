/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.jooq.tables;


import de.kittybot.kittybot.jooq.Keys;
import de.kittybot.kittybot.jooq.Public;
import de.kittybot.kittybot.jooq.tables.records.MemberRolesRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class MemberRoles extends TableImpl<MemberRolesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.member_roles</code>
     */
    public static final MemberRoles MEMBER_ROLES = new MemberRoles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MemberRolesRecord> getRecordType() {
        return MemberRolesRecord.class;
    }

    /**
     * The column <code>public.member_roles.id</code>.
     */
    public final TableField<MemberRolesRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.member_roles.guild_id</code>.
     */
    public final TableField<MemberRolesRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.member_roles.user_id</code>.
     */
    public final TableField<MemberRolesRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.member_roles.role_id</code>.
     */
    public final TableField<MemberRolesRecord, Long> ROLE_ID = createField(DSL.name("role_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private MemberRoles(Name alias, Table<MemberRolesRecord> aliased) {
        this(alias, aliased, null);
    }

    private MemberRoles(Name alias, Table<MemberRolesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.member_roles</code> table reference
     */
    public MemberRoles(String alias) {
        this(DSL.name(alias), MEMBER_ROLES);
    }

    /**
     * Create an aliased <code>public.member_roles</code> table reference
     */
    public MemberRoles(Name alias) {
        this(alias, MEMBER_ROLES);
    }

    /**
     * Create a <code>public.member_roles</code> table reference
     */
    public MemberRoles() {
        this(DSL.name("member_roles"), null);
    }

    public <O extends Record> MemberRoles(Table<O> child, ForeignKey<O, MemberRolesRecord> key) {
        super(child, key, MEMBER_ROLES);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<MemberRolesRecord, Long> getIdentity() {
        return (Identity<MemberRolesRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<MemberRolesRecord> getPrimaryKey() {
        return Keys.MEMBER_ROLES_PKEY;
    }

    @Override
    public List<UniqueKey<MemberRolesRecord>> getKeys() {
        return Arrays.<UniqueKey<MemberRolesRecord>>asList(Keys.MEMBER_ROLES_PKEY, Keys.MEMBER_ROLES_GUILD_ID_USER_ID_ROLE_ID_KEY);
    }

    @Override
    public List<ForeignKey<MemberRolesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MemberRolesRecord, ?>>asList(Keys.MEMBER_ROLES__MEMBER_ROLES_GUILD_ID_FKEY);
    }

    public Guilds guilds() {
        return new Guilds(this, Keys.MEMBER_ROLES__MEMBER_ROLES_GUILD_ID_FKEY);
    }

    @Override
    public MemberRoles as(String alias) {
        return new MemberRoles(DSL.name(alias), this);
    }

    @Override
    public MemberRoles as(Name alias) {
        return new MemberRoles(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MemberRoles rename(String name) {
        return new MemberRoles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MemberRoles rename(Name name) {
        return new MemberRoles(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, Long, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
