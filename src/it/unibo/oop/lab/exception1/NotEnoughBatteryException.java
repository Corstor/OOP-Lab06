package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870275637662522894L;
	private final double batteryLeft;
	private final double batteryRequired;
	
	/**
     * Construct new instance of the exception.
     */
	public NotEnoughBatteryException(final double batteryLeft, final double batteryRequired) {
		super();
		this.batteryLeft = batteryLeft;
		this.batteryRequired = batteryRequired;
	}

	/**
     * 
     * @return the string representation of instances of this class
     */
	@Override
	public String toString() {
		return "Cannot move; Battery left: " + this.batteryLeft + ", battery required: " + this.batteryRequired;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}
}
