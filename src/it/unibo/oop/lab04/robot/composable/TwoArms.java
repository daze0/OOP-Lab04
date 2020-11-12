package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.arms.BasicArm;

public class TwoArms extends AbstractComponentWithCommands{
	
	private final BasicArm leftArm;
	private final BasicArm rightArm;
	private int nCarriedItems;
	
	public TwoArms() {
		super("Two Arms", new String[] {"pick", "drop"});
		this.leftArm = new BasicArm("left");
		this.rightArm = new BasicArm("right");
		this.nCarriedItems = 0;
	}
	
	private void doPickUp(ComposableRobot cr) {
		if(!this.leftArm.isGrabbing()) {	//If leftArm is free
			this.leftArm.pickUp();
		}
		else if(!this.rightArm.isGrabbing()) {	//If rightArm is free
			this.rightArm.pickUp();
		}
		this.nCarriedItems++;
		cr.consumeBattery(leftArm.getConsumptionForPickUp());
	}
	
	public boolean pickUp(ComposableRobot cr) {
		if(this.leftArm.isGrabbing() && this.rightArm.isGrabbing()) {	//If both arms are grabbing something
			return false;
		}
		else {
			this.doPickUp(cr);
			return true;
		}
	}
	
	private void doDropDown(ComposableRobot cr) {
		if(this.leftArm.isGrabbing()) {	//If leftArm is grabbing
			this.leftArm.dropDown();
		}
		else if(this.rightArm.isGrabbing()) {	//If rightArm is grabbing
			this.rightArm.dropDown();
		}
		this.nCarriedItems--;
		cr.consumeBattery(leftArm.getConsumptionForDropDown());
	}
	
	public boolean dropDown(ComposableRobot cr) {
		if(!this.leftArm.isGrabbing() && !this.rightArm.isGrabbing()) {	  //If both arms are grabbing something
			return false;
		}
		else {
			this.doDropDown(cr);
			return true;
		}
	}
	
	public int getCarriedItemsCount() {
		return nCarriedItems;
	}

	public double getBatteryConsumptionWhileCarrying() {
		return this.getCarriedItemsCount() * this.leftArm.getConsumptionForPickUp();
	}

	public void use(ComposableRobot cr) {
		if(this.getCurrentCommand() == "pick") {
			this.pickUp(cr);
		}
		else if(this.getCurrentCommand() == "drop") {
			this.dropDown(cr);
		}
		else {
			System.out.println("ERROR: Invalid command..");
		}
	}
	
}
