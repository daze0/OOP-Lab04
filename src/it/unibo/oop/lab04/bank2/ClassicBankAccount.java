package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {
	
	public ClassicBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
	public boolean isWithDrawAllowed(double amount) {
		return true;
	}
	
	public double computeFee() {
		return ClassicBankAccount.MANAGEMENT_FEE;
 	}
}
