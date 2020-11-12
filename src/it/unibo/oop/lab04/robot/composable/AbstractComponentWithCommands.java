package it.unibo.oop.lab04.robot.composable;

public abstract class AbstractComponentWithCommands extends AbstractComponent{

	private String[] commandSet;
	private String currentCommand;
	
	public AbstractComponentWithCommands(final String componentName, final String[] commandSet) {
		super(componentName);
		this.commandSet = commandSet;
		this.currentCommand = null;
	}
	
	public boolean setCommand(String command) {
		if(findCommand(command)) {
			this.currentCommand = command;
		}
		return false;
	}
	
	private boolean findCommand(String command) {
		for(String s : this.commandSet) {
			if(s == command) {
				return true;
			}
		}
		return false;
	}
	
	public String getCurrentCommand() {
		return this.currentCommand;
	}
}
