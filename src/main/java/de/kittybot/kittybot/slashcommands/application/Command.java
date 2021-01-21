package de.kittybot.kittybot.slashcommands.application;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.utils.data.DataObject;

import java.util.*;

public abstract class Command implements CommandOptionsHolder, PermissionHolder{

	private final String name, description;
	private final Category category;
	private final Set<Permission> permissions;
	private final List<CommandOption> options;
	private boolean devOnly;

	protected Command(String name, String description, Category category){
		this.name = name;
		this.description = description;
		this.category = category;
		this.devOnly = false;
		this.permissions = new HashSet<>();
		this.options = new ArrayList<>();
	}

	public void devOnly(){
		this.devOnly = true;
	}

	public boolean isDevOnly(){
		return this.devOnly;
	}

	public void addPermissions(Permission... permissions){
		this.permissions.addAll(Arrays.asList(permissions));
	}

	public Set<Permission> getPermissions(){
		return this.permissions;
	}

	protected void addOptions(CommandOption... options){
		this.options.addAll(List.of(options));
	}

	public String getName(){
		return this.name;
	}

	public String getDescription(){
		return this.description;
	}

	public Category getCategory(){
		return this.category;
	}

	public List<CommandOption> getOptions(){
		return this.options;
	}

	public DataObject toJSON(){
		var json = DataObject.empty()
			.put("name", this.name)
			.put("description", this.description);
		if(!this.options.isEmpty()){
			json.put("options", CommandOption.toJSON(this.options));
		}
		return json;
	}

}