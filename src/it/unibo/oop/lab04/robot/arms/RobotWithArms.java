package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

public interface RobotWithArms extends Robot{
	/** 
	 * picks an object
	 * 
	 * @return true if the action is successful
	 */
	boolean pickUp();
	/** 
	 * drops an object
	 * 
	 * @return true if the action is successful
	 */
	boolean dropDown();
	/**
	 * @return number of objects the robot is currently carrying
	 */
	int getCarriedItemsCount();
}
