package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186015990336694793L;
	private final int totalTransactionCount;
	private final int maximumAllowedATMTransactions;
	
	public TransactionsOverQuotaException(final int totalTransactionCount, final int maximumAllowedATMTransactions) {
		this.totalTransactionCount = totalTransactionCount;
		this.maximumAllowedATMTransactions = maximumAllowedATMTransactions;
	}

	public String toString() {
		return "Maximum number of ATM transactions reached. Maximum ATM transactions: " + this.maximumAllowedATMTransactions 
				+ ", total transactions already done: " + this.totalTransactionCount;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
