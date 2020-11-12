package it.unibo.oop.lab04.robot.composable;

public interface Component {
	
	/**
	 * @return true if the component is on, false if it's not
	 */
	boolean isOn();
	
	/**
	 * switches the component on
	 */
	void switchOn();
	
	/**
	 * switches the component off
	 */
	void switchOff();
	
	/**
	 * @return true if the component is connected to a robot, false otherwise
	 */
	boolean isConnected();
	
	/**
	 * @return true if the component is been connected, false if it's already connected
	 */
	boolean connect();
	
	/**
	 * disconnects the component from the robot
	 */
	void disconnect();
	
	/**
	 * if invoked the component starts working
	 */
	void use(ComposableRobot cr);
}
