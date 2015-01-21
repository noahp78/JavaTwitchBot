package noahp78.twitch.commands;

public class CommandAbout extends Command{

	String commandname(){
		return "!about";
	
	}
	String response(String com, String sender) {
		return ("Hey there " + sender + " this is TwitchBot V0.0.1 ready to serve you the best experience ever!");
		
		
		
	}
	@Override
	String description() {
		// TODO Auto-generated method stub
		return "Version info about the bot";
	}
	
}
