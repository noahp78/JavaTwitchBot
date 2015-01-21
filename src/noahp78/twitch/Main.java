package noahp78.twitch;

import java.io.IOException;

import noahp78.twitch.commands.CommandAbout;
import noahp78.twitch.commands.CommandHelp;
import noahp78.twitch.commands.CommandHelper;
import noahp78.twitch.plugin.Event;
import noahp78.twitch.plugin.EventPublisher;
import noahp78.twitch.plugin.PluginSystem;
import noahp78.twitch.plugin.events.BotConnectedEvent;
import noahp78.twitch.util.Config;

import org.jibble.pircbot.IrcException;

public class Main {
	static TwitchBot bot;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CommandHelper.Register(new CommandAbout());
        CommandHelper.Register(new CommandHelp());
        //Give plugins time to start
        System.out.println("Starting PluginSystem");
        try {
			PluginSystem.Init();
		} catch (Exception e1) {
			System.out.println("FAILED TO START PLUGINSYSTEM: ");// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        bot = new TwitchBot();
		// Enable debugging output.
        bot.setVerbose(true);
        bot.changeNick(Config.username);
        // Connect to the IRC server.
        try {
			bot.connect("irc.imstreaming.tk");
			Event event = new BotConnectedEvent();
			event.isCancelled=true;
			if(!EventPublisher.raiseEvent(event)){
				System.out.println("Joining server has been cancelled!");
			}
			bot.joinChannel("#test");
			
		} catch (IOException | IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Join the #pircbot channel.

	}
	public static TwitchBot GetBot(){
		return bot;
		
	}

}
