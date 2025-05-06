package com.epam;

/**
 * The type Bank account.
 */
class BankAccount {
    private final String accountNumber;
    private double balance;

    /**
     * Instantiates a new Bank account.
     *
     * @param accountNumber  the account number
     * @param initialBalance the initial balance
     */
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Withdraw.
     *
     * @param amount the amount
     * @throws BankException the bank exception
     */
    public void withdraw(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new BankException("Insufficient funds for the withdrawal.");
        }
        balance -= amount;
    }

    /**
     * Find account bank account.
     *
     * @param accountNumber the account number
     * @return the bank account
     * @throws BankException the bank exception
     */
    public static BankAccount findAccount(String accountNumber) throws BankException {
        if (accountNumber.equals("12345")) {
            return new BankAccount("12345", 10000.00);
        } else {
            throw new BankException("Account not found with number: " + accountNumber);
        }
    }
}
