package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;

	private final double balance;
	private final double amountRequested;
	
	public NotEnoughFoundsException(double balance, double amountRequested) {
		super();
		this.balance = balance;
		this.amountRequested = amountRequested;
	}
	
	public String toString() {
		return "Impossible to withdraw. Total balance: " + this.balance + ", requested amount: " + this.amountRequested;
	}

	public String getMessage() {
		return this.toString();
	}
}
