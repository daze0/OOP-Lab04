package it.unibo.oop.lab04.robot.composable;

public class AtomicBattery extends AbstractComponent{

	public AtomicBattery() {
		super("Atomic Battery");
	}

	public void use(ComposableRobot cr) {
		cr.recharge();
	}
	
}
