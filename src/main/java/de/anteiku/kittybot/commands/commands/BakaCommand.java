package de.anteiku.kittybot.commands.commands;

import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.commands.ACommand;
import de.anteiku.kittybot.commands.CommandContext;

public class BakaCommand extends ACommand{

	public static final String COMMAND = "baka";
	public static final String USAGE = "baka <@user, ...>";
	public static final String DESCRIPTION = "Says baka to a user";
	protected static final String[] ALIAS = {"dummy", "dummi"};

	public BakaCommand(){
		super(COMMAND, USAGE, DESCRIPTION, ALIAS);
	}

	@Override
	public void run(CommandContext ctx){
		if(ctx.getArgs().length == 0){
			sendUsage(ctx);
			return;
		}
		sendReactionImage(ctx, "baka", "said baka to");
	}

}
