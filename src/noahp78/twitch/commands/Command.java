package noahp78.twitch.commands;

public abstract class Command {
	abstract String commandname();
	abstract String response(String com, String sender);
	Boolean Register;
}
