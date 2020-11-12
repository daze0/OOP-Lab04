package it.unibo.oop.lab04.robot.composable;

public abstract class AbstractComponent implements Component{
	
	private boolean isSwitchedOn;
	private boolean isConnected;
	private String componentName;
	
	public AbstractComponent(String name) {
		this.componentName = name;
	}
	
	public boolean isOn() {
		return this.isSwitchedOn;
	}
	
	public void switchOn() {
		this.isSwitchedOn = true;
	}
	
	public void switchOff() {
		this.isSwitchedOn = false;
	}
	
	public boolean isConnected() {
		return this.isConnected;
	}
	
	public boolean connect() {
		if(this.isConnected) {
			return false;
		}
		this.isConnected = true;
		return true;
	}
	
	public void disconnect() {
		this.isConnected = false;
	}
	
	public abstract void use(ComposableRobot cr);
	
}
