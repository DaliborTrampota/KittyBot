package de.kittybot.kittybot.slashcommands.application.options;

import de.kittybot.kittybot.objects.exceptions.OptionParseException;
import de.kittybot.kittybot.slashcommands.application.CommandOption;
import de.kittybot.kittybot.slashcommands.application.CommandOptionType;

public class CommandOptionUser extends CommandOption<Long>{

	public CommandOptionUser(String name, String description){
		super(CommandOptionType.USER, name, description);
	}

	@Override
	public Long parseValue(Object value){
		try{
			return Long.parseLong((String) value);
		}
		catch(ClassCastException | NumberFormatException e){
			throw new OptionParseException("Failed to parse option as user");
		}
	}

}
