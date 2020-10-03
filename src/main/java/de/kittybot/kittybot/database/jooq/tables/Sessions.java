/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables;


import de.kittybot.kittybot.database.jooq.Keys;
import de.kittybot.kittybot.database.jooq.Public;
import de.kittybot.kittybot.database.jooq.tables.records.SessionsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Sessions extends TableImpl<SessionsRecord>{

	/**
	 * The reference instance of <code>public.sessions</code>
	 */
	public static final Sessions SESSIONS = new Sessions();
	private static final long serialVersionUID = -517766618;
	/**
	 * The column <code>public.sessions.session_key</code>.
	 */
	public final TableField<SessionsRecord, String> SESSION_KEY = createField(DSL.name("session_key"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");
	/**
	 * The column <code>public.sessions.user_id</code>.
	 */
	public final TableField<SessionsRecord, String> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(18).nullable(false), this, "");
	/**
	 * The column <code>public.sessions.access_token</code>.
	 */
	public final TableField<SessionsRecord, String> ACCESS_TOKEN = createField(DSL.name("access_token"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");
	/**
	 * The column <code>public.sessions.refresh_token</code>.
	 */
	public final TableField<SessionsRecord, String> REFRESH_TOKEN = createField(DSL.name("refresh_token"), org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");
	/**
	 * The column <code>public.sessions.expiration</code>.
	 */
	public final TableField<SessionsRecord, LocalDateTime> EXPIRATION = createField(DSL.name("expiration"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

	/**
	 * Create a <code>public.sessions</code> table reference
	 */
	public Sessions(){
		this(DSL.name("sessions"), null);
	}

	private Sessions(Name alias, Table<SessionsRecord> aliased){
		this(alias, aliased, null);
	}

	private Sessions(Name alias, Table<SessionsRecord> aliased, Field<?>[] parameters){
		super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
	}

	/**
	 * Create an aliased <code>public.sessions</code> table reference
	 */
	public Sessions(String alias){
		this(DSL.name(alias), SESSIONS);
	}

	/**
	 * Create an aliased <code>public.sessions</code> table reference
	 */
	public Sessions(Name alias){
		this(alias, SESSIONS);
	}

	public <O extends Record> Sessions(Table<O> child, ForeignKey<O, SessionsRecord> key){
		super(child, key, SESSIONS);
	}

	@Override
	public Sessions as(String alias){
		return new Sessions(DSL.name(alias), this);
	}

	@Override
	public Schema getSchema(){
		return Public.PUBLIC;
	}

	@Override
	public UniqueKey<SessionsRecord> getPrimaryKey(){
		return Keys.SESSIONS_PKEY;
	}

	@Override
	public List<UniqueKey<SessionsRecord>> getKeys(){
		return Arrays.<UniqueKey<SessionsRecord>>asList(Keys.SESSIONS_PKEY);
	}

	@Override
	public Sessions as(Name alias){
		return new Sessions(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public Sessions rename(String name){
		return new Sessions(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public Sessions rename(Name name){
		return new Sessions(name, null);
	}

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<SessionsRecord> getRecordType(){
		return SessionsRecord.class;
	}

	// -------------------------------------------------------------------------
	// Row5 type methods
	// -------------------------------------------------------------------------

	@Override
	public Row5<String, String, String, String, LocalDateTime> fieldsRow(){
		return (Row5) super.fieldsRow();
	}

}