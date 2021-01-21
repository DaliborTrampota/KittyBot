package de.kittybot.kittybot.web.commands;

import de.kittybot.kittybot.modules.CommandsModule;
import de.kittybot.kittybot.modules.WebService;
import de.kittybot.kittybot.objects.module.Modules;
import de.kittybot.kittybot.slashcommands.application.Category;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GetCommandsRoute implements Handler{

	private final Modules modules;

	public GetCommandsRoute(Modules modules){
		this.modules = modules;
	}

	@Override
	public void handle(@NotNull Context ctx){
		var commandSet = this.modules.get(CommandsModule.class).getCommands().values();
		var categories = DataArray.fromCollection(
			Arrays.stream(Category.values()).map(category ->
				DataObject.empty().put("name", category.getName()).put("emote_url", category.getEmoteUrl()).put("commands", DataArray.fromCollection(
					commandSet.stream().filter(cmd -> cmd.getCategory() == category).map(cmd ->
						DataObject.empty().put("command", cmd.getName())/*.put("usage", cmd.getUsage())*/.put("description", cmd.getDescription())
					).collect(Collectors.toSet())
				))
			).collect(Collectors.toSet())
		);
		WebService.ok(ctx, DataObject.empty().put("prefix", "/").put("categories", categories));
	}


}