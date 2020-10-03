/*
 * This file is generated by jOOQ.
 */
package de.kittybot.kittybot.database.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class SelfAssignableRoles implements Serializable{

	private static final long serialVersionUID = 808033970;

	private final String roleId;
	private final String guildId;
	private final String emoteId;

	public SelfAssignableRoles(SelfAssignableRoles value){
		this.roleId = value.roleId;
		this.guildId = value.guildId;
		this.emoteId = value.emoteId;
	}

	public SelfAssignableRoles(
			String roleId,
			String guildId,
			String emoteId
	){
		this.roleId = roleId;
		this.guildId = guildId;
		this.emoteId = emoteId;
	}

	public String getRoleId(){
		return this.roleId;
	}

	public String getGuildId(){
		return this.guildId;
	}

	public String getEmoteId(){
		return this.emoteId;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("SelfAssignableRoles (");

		sb.append(roleId);
		sb.append(", ").append(guildId);
		sb.append(", ").append(emoteId);

		sb.append(")");
		return sb.toString();
	}

}