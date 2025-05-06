package com.epam;

/**
 * The type Bank application.
 */
public class BankApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            // find an account that doesn't exist
            BankAccount account = BankAccount.findAccount("90800");
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Valid account, but invalid withdrawal amount
            BankAccount account = BankAccount.findAccount("12345");
            account.withdraw(-500);
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Valid account but insufficient funds
            BankAccount account = BankAccount.findAccount("12345");
            account.withdraw(1500);
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Valid account and valid withdrawal
            BankAccount account = BankAccount.findAccount("12345");
            account.withdraw(500);
            System.out.println("Withdrawal successful! Remaining balance: " + account.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
