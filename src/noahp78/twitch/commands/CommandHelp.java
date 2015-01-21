package noahp78.twitch.commands;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import noahp78.twitch.Main;
import noahp78.twitch.TwitchBot;

public class CommandHelp extends Command{

	@Override
	String commandname() {
		// TODO Auto-generated method stub
		return "!help";
	}

	@Override
	String response(String com, String sender) {
		// TODO Auto-generated method stub
		HashMap<String, Command> mp = CommandHelper.get();
		Iterator<Entry<String, Command>> it = mp.entrySet().iterator();
	    TwitchBot bot = Main.GetBot();
	    bot.sendMessage(sender, "All registered commands: ");
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
	        bot.sendMessage(sender, " " + pairs.getKey());
	        bot.sendMessage(sender, "     " + (((Command) pairs.getValue()).description()));
	    	bot.sendMessage(sender, "        " + pairs.getValue());
	    	it.remove(); // avoids a ConcurrentModificationException
	    }
		return " Please check your private messages " + sender;
		
		
	}

	@Override
	String description() {
		// TODO Auto-generated method stub
		return "List all the commands";
	}

}
