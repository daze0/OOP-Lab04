package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.Position2D;

public class BorderNavigator extends AbstractComponent{

	private static final double USAGE_DELTA_CONSUMPTION = 0.5;
	
	public BorderNavigator() {
		super("Border Navigator");
	}

	public double getBatteryConsumption() {
		return USAGE_DELTA_CONSUMPTION;
	}

	public void use(ComposableRobot cr) {
		while(cr.moveRight());
		Position2D borderNavStart = cr.getPosition();
		while(cr.moveDown());
		while(cr.moveLeft());
		while(cr.moveUp());
		while(cr.moveRight());
		while(cr.getPosition() != borderNavStart) {
			cr.moveDown();
		}
	}
	
}
