package noahp78.twitch;

import noahp78.twitch.commands.CommandHelper;
import noahp78.twitch.util.Config;

import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.User;

public class TwitchBot extends PircBot {
    public TwitchBot() {
        this.setName(Config.username);
    }
    
    public void onMessage(String channel, String sender,
        String login, String hostname, String message) {
			if (message.equalsIgnoreCase("time")) {
				String time = new java.util.Date().toString();
				sendMessage(channel, sender + ": The time is now " + time);
			}else if(CommandHelper.execute(message, sender)!=null){
				sendMessage(channel, CommandHelper.execute(message, sender));
			}
		}
    
    public void onJoin(String channel, String sender, String login, String hostname) {
    	for (User user : this.getUsers(channel)) {
    		if(user.getNick().contains(Config.username)){
    			//It's me!
    			if(!(user.isOp())){
    				sendMessage(channel, " I need operator rights to be able to work. please give them to me!");
    			}
    		}
    	}
    	    
    	sendMessage(channel, " Welcome to the party " + login + "!");
    }
}
