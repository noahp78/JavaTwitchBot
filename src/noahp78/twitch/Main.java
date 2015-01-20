package noahp78.twitch;

import java.io.IOException;

import noahp78.twitch.commands.CommandAbout;
import noahp78.twitch.commands.CommandHelper;
import noahp78.twitch.util.Config;

import org.jibble.pircbot.IrcException;

public class Main {
	static TwitchBot bot;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CommandHelper.Register(new CommandAbout());
        
        bot = new TwitchBot();
		// Enable debugging output.
        bot.setVerbose(true);
        bot.changeNick(Config.username);
        // Connect to the IRC server.
        try {
			bot.connect("irc.imstreaming.tk");
	        bot.joinChannel("#test");

		} catch (IOException | IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Join the #pircbot channel.

	}

}
