package com.epam;

/**
 * The type Account.
 */
class Account {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    /**
     * Instantiates a new Account.
     *
     * @param accountNumber  the account number
     * @param holderName     the holder name
     * @param initialBalance the initial balance
     */
    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    /**
     * Deposit.
     *
     * @param amount the amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw boolean.
     *
     * @param amount the amount
     */
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }}

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets holder name.
     *
     * @return the holder name
     */
    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return holderName + " [" + accountNumber + "] - Balance: Rs. " + balance;
    }
}
