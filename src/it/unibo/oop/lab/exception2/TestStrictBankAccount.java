package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	private final static int IN_AMOUNT = 10_000;
	private final static int N_MAX_ATM_TRANSACTIONS = 10;
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10_000 e nMaxATMTransactions=10
         */
    	
    	final AccountHolder accountHolder1 = new AccountHolder("Marco", "Verdi", 1);
    	final AccountHolder accountHolder2 = new AccountHolder("Andrea", "Bianchi", 2);
    	
    	final StrictBankAccount marcoBank = new StrictBankAccount(accountHolder1.getUserID(), IN_AMOUNT, N_MAX_ATM_TRANSACTIONS);
    	final StrictBankAccount andreaBank = new StrictBankAccount(accountHolder2.getUserID(), IN_AMOUNT, N_MAX_ATM_TRANSACTIONS);
    	
        /* 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	try {
    		marcoBank.withdraw(1, IN_AMOUNT);
    		System.out.println("Marco now has " + marcoBank.getBalance() + " euros");
    		
    		marcoBank.withdraw(1, 1); //Should fail
    		
    		fail();
    	} catch (NotEnoughFoundsException e) {
    		assertNotNull(e.getMessage());
    	}
    	
    	System.out.println("Marco euros should not be changed: " + marcoBank.getBalance());
    	
    	
    	//2nd Test
    	try {
    		andreaBank.withdraw(1, IN_AMOUNT); //Should fail
    		
    		fail();
    	} catch (WrongAccountHolderException e) {
    		assertNotNull(e.getMessage());
    	}
    	
    	System.out.println("Andrea euros should not be changed: " + andreaBank.getBalance());
    	
    	try {
    		for (int i = 0; i < N_MAX_ATM_TRANSACTIONS; i++) {
    			marcoBank.deposit(1, i);
    		}
    		
    		System.out.println("Marco now has " + marcoBank.getBalance() + " euros");
    		
    		marcoBank.depositFromATM(1, IN_AMOUNT);
    		
    		fail();
    	} catch (TransactionsOverQuotaException e) {
    		assertNotNull(e.getMessage());
    	}
    	
    	System.out.println("Marco euros should not be changed: " + marcoBank.getBalance());
    	
    }
}
