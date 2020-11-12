package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount{
	/* CONSTANTS */
	public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
    /* FIELDS */
    private final int usrID;
    private double balance;
    private int nTransactions;
    /* CONSTRUCTOR */
	public AbstractBankAccount(int usrID, double balance) {
		this.usrID = usrID;
		this.balance = balance;
		this.nTransactions = 0;
	}
	/* GETTERS/SETTERS */
	public final double getBalance() {
        return this.balance;
    }

    public final int getNTransactions() {
        return this.nTransactions;
    }

    protected final void incTransactions() {
        this.nTransactions++;
    }

    protected final void resetTransactions() {
        this.nTransactions = 0;
    }

    public final void setBalance(final double amount) {
        this.balance = amount;
    }
    /* Checks if user is the given one */
	protected boolean checkUser(final int id) {
        return this.usrID == id;
    }
	/* Transactions management */
	private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }
	
	public final void deposit(final int usrID, final double amount) {
        this.transactionOp(usrID, amount);
    }

    public final void depositFromATM(final int usrID, final double amount) {
       this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
    }
   
	public final void withdraw(final int usrID, final double amount) {
		if (this.isWithDrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
    }
	
	public final void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
    }
	
	public final void computeManagementFees(final int usrID) {
        final double feeAmount = this.computeFee();
        if (this.checkUser(usrID) && this.isWithDrawAllowed(feeAmount)) {
            this.balance -= feeAmount;
            resetTransactions();
        }
    }
	/* Implementable methods */ 
	protected abstract boolean isWithDrawAllowed(double amount);
	protected abstract double computeFee();
    
}
