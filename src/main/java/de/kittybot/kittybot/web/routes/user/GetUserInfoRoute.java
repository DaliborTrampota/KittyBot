package de.kittybot.kittybot.web.routes.user;

import de.kittybot.kittybot.exceptions.TooManyRequestResponse;
import de.kittybot.kittybot.module.Modules;
import de.kittybot.kittybot.web.WebService;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.NotFoundResponse;
import net.dv8tion.jda.api.exceptions.HttpException;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.stream.Collectors;

public class GetUserInfoRoute implements Handler{

	private final Modules modules;

	public GetUserInfoRoute(Modules modules){
		this.modules = modules;
	}

	@Override
	public void handle(@NotNull Context ctx){
		var userId = this.modules.getWebService().getUserId(ctx);
		var session = this.modules.getDashboardSessionModule().get(userId);
		if(session == null){
			throw new NotFoundResponse("Session not found");
		}
		var user = this.modules.getJDA().retrieveUserById(userId).complete();
		if(user == null){
			throw new NotFoundResponse("User not found");
		}
		try{
			var guilds = this.modules.getDashboardSessionModule().getOAuth2Client().getGuilds(session).complete();
			var guildData = DataArray.fromCollection(
					guilds.stream().filter(
							guild -> this.modules.getJDA().getGuildCache().stream().anyMatch(g -> g.getIdLong() == guild.getIdLong())
					).map(
							guild -> DataObject.empty().put("id", guild.getId()).put("name", guild.getName()).put("icon", guild.getIconUrl())
					).collect(Collectors.toSet())
			);
			WebService.ok(ctx, DataObject.empty().put("name", user.getName()).put("id", userId).put("icon", user.getEffectiveAvatarUrl()).put("guilds", guildData));
		}
		catch(IOException e){
			throw new InternalServerErrorResponse("There was a problem while login. Please try again");
		}
		catch(HttpException e){
			throw new TooManyRequestResponse("Discord ratelimits us please wait with your request");
		}
	}

}
