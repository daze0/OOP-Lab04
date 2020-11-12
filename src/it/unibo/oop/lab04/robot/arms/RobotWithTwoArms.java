package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	
	public static final double PICK_UP_BATTERY_CONSUMPTION = 0.2;
	public static final double DROP_DOWN_BATTERY_CONSUMPTION = 0.1;
	
	private final BasicArm leftArm;
	private final BasicArm rightArm;
	private int nCarriedItems;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		this.leftArm = new BasicArm(robotName + "_left");
		this.rightArm = new BasicArm(robotName + "_right");
	}

	private void doPickUp() {
		if(!this.leftArm.isGrabbing()) {	//If leftArm is free
			this.leftArm.pickUp();
		}
		else if(!this.rightArm.isGrabbing()) {	//If rightArm is free
			this.rightArm.pickUp();
		}
		this.nCarriedItems++;
		this.consumeBattery(PICK_UP_BATTERY_CONSUMPTION);
	}
	
	protected double getBatteryRequirementForMovement() {
        return super.getBatteryRequirementForMovement() + this.getCarriedItemsCount() * PICK_UP_BATTERY_CONSUMPTION;
    }
	
	public boolean pickUp() {
		if(this.leftArm.isGrabbing() && this.rightArm.isGrabbing()) {	//If both arms are grabbing something
			return false;
		}
		else {
			this.doPickUp();
			return true;
		}
	}

	private void doDropDown() {
		if(this.leftArm.isGrabbing()) {	//If leftArm is grabbing
			this.leftArm.dropDown();
		}
		else if(this.rightArm.isGrabbing()) {	//If rightArm is grabbing
			this.rightArm.dropDown();
		}
		this.nCarriedItems--;
		this.consumeBattery(DROP_DOWN_BATTERY_CONSUMPTION);
	}
	
	public boolean dropDown() {
		if(!this.leftArm.isGrabbing() && !this.rightArm.isGrabbing()) {	  //If both arms are grabbing something
			return false;
		}
		else {
			this.doDropDown();
			return true;
		}
	}

	public int getCarriedItemsCount() {
		return nCarriedItems;
	}
}
