package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7298746005923212613L;
	private final int usrIDRequested;
	private final int usrIDSent;
	
	public WrongAccountHolderException(int usrIDRequested, int usrIDSent) {
		super();
		this.usrIDRequested = usrIDRequested;
		this.usrIDSent = usrIDSent;
	}

	@Override
	public String toString() {
		return "User ID not accettable. User ID requested: " + this.usrIDRequested + ", user ID sent: " + this.usrIDSent;
	}
	
	public String getMessage() {
		return this.toString();
	}

}
