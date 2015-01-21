package noahp78.twitch.commands;

import java.util.HashMap;

public class CommandHelper {
	private static HashMap<String,Command>commands = new HashMap<String,Command>();
	public static boolean Register(Command com){
		if (!((commands.containsKey((com.commandname()))))){
			System.out.println("[CommandHelper] Registering " + com.commandname() + " for " + com);
			
			commands.put(com.commandname(), com);
			return true;
		}else{
			System.out.println("[CommandHelper] Not Registering " + com.commandname() + " for " + com);
			
			return false;
		}
	}
	public static String execute(String command, String sender){
		if(command.startsWith("!")){
			for (String s : command.split(" ")) {
				System.out.println("Can I do " + s);
				if(commands.get(s)!=null){
					return commands.get(s).response(command, sender);
				}
			}
				return "I don't know how to do that. please do !help";
			}
		return null;
		
		}		
	public static HashMap get(){
		return (HashMap) commands.clone();
		
	}
}