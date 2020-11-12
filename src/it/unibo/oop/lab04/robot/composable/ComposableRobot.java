package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class ComposableRobot extends BaseRobot{
	
	private static final int MAX_COMPONENTS = 10;

	private Component[] components;
	
	public ComposableRobot(final String robotName) {
		super(robotName);
		this.components = new Component[MAX_COMPONENTS];
	}
	
	public boolean addComponent(final Component c, final int position) {
		if(position <= MAX_COMPONENTS) {
			c.connect();
			this.components[position] = c;
			return true;
		}
		return false;
	}
	
	public boolean removeComponent(final int position) {
		if(position >= 0 && position <= MAX_COMPONENTS) {
			this.components[position].disconnect();
			this.components[position] = null;
			return true;
		}
		return false;
	}
	
	public void useAll() {
		for(Component c : this.components) {
			if(c.isOn()) {
				c.use(this);
			}
		}
	}
	
}
