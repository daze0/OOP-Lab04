package it.unibo.oop.lab04.robot.arms;

public class BasicArm {

	private static final double DELTA_PICKUP = 2.5;
	private static final double DELTA_DROPDOWN = 1.5;
	
	private final String name;
	private boolean isCarryingSomething;
	
	public BasicArm(String name) {
		this.name = name;
	}
	
	public boolean isGrabbing() {
		return this.isCarryingSomething;
	}
	
	public void pickUp() {
		if(!this.isGrabbing()) {
			this.isCarryingSomething = true;
		}
	}
	
	public void dropDown() {
		if(this.isGrabbing()) {
			this.isCarryingSomething = false;
		}
	}
	
	public double getConsumptionForPickUp() {
		return DELTA_PICKUP;
	}
	
	public double getConsumptionForDropDown() {
		return DELTA_DROPDOWN;
	}

	public String toString() {
		return this.name;
	}
	
}
