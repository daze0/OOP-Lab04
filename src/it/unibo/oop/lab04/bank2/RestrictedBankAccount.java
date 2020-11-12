package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{

	private static final double TRANSACTION_FEE = 0.1;
	
	public RestrictedBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
	public boolean isWithDrawAllowed(double amount) {
		return this.getBalance() >= amount;
	}
	
	public double computeFee() {
		return RestrictedBankAccount.MANAGEMENT_FEE + (this.getNTransactions() * RestrictedBankAccount.TRANSACTION_FEE);
 	}
}
