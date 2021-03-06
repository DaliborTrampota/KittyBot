package de.kittybot.kittybot.commands.utility;

import de.kittybot.kittybot.modules.RequestModule;
import de.kittybot.kittybot.slashcommands.application.Category;
import de.kittybot.kittybot.slashcommands.application.Command;
import de.kittybot.kittybot.slashcommands.application.RunnableCommand;
import de.kittybot.kittybot.slashcommands.application.options.CommandOptionUrl;
import de.kittybot.kittybot.slashcommands.context.CommandContext;
import de.kittybot.kittybot.slashcommands.context.Options;
import de.kittybot.kittybot.utils.Config;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static de.kittybot.kittybot.utils.MessageUtils.maskLink;

@SuppressWarnings("unused")
public class HastebinCommand extends Command implements RunnableCommand{

	public HastebinCommand(){
		super("hastebin", "Creates a hastebin from the latest attachment in this channel or a provided url", Category.UTILITIES);
		addOptions(
			new CommandOptionUrl("url", "The url to create a hastebin from")
		);
	}

	@Override
	public void run(Options options, CommandContext ctx){
		if(Config.HASTEBIN_URL.isBlank()){
			ctx.error("No hastebin url configured");
			return;
		}
		if(options.has("url")){
			ctx.get(RequestModule.class).retrieveUrlContent(options.getString("url"),
				(call, response) -> {
					var body = response.body();
					if(body == null){
						ctx.error("Provided link has no content");
						return;
					}
					try{
						ctx.get(RequestModule.class).postToHastebin(body.string(), key -> {
							if(key == null){
								ctx.error("Unexpected error while creating hastebin");
								return;
							}
							ctx.reply(maskLink("here is a hastebin", Config.HASTEBIN_URL + "/" + key));
						});
					}
					catch(IOException e){
						ctx.error("Error while getting body data from link");
					}
				}
				, (call, response) -> ctx.error("Error while retrieving data from link"));
			return;
		}
		ctx.getChannel().getIterableHistory().takeAsync(25).thenAcceptAsync(messages -> {
			var message = messages.stream().filter(msg -> !msg.getAttachments().isEmpty() && msg.getAttachments().stream().anyMatch(attachment -> !attachment.isImage() && !attachment.isVideo())).findFirst();
			if(message.isEmpty()){
				ctx.error("No file found to in recent 25 messages");
				return;
			}
			message.get().getAttachments().forEach(attachment ->
				attachment.retrieveInputStream().thenAcceptAsync(inputStream -> {
					try(inputStream){
						var text = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
						ctx.get(RequestModule.class).postToHastebin(text, key -> {
							if(key == null){
								ctx.error("Unexpected error while creating hastebin");
								return;
							}
							ctx.reply(maskLink("here is a hastebin", Config.HASTEBIN_URL + "/" + key));
						});
					}
					catch(IOException e){
						ctx.error("Error while creating hastebin\nError: " + e.getMessage());
					}
				})
			);
		});
	}

}
