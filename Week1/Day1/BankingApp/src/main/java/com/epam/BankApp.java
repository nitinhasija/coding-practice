package com.epam;

import java.util.*;

/**
 * Bank App
 */
public class BankApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();

        accounts.put("001", new Account("001", "Ram", 100000));
        accounts.put("002", new Account("002", "Sham", 250000));
        accounts.put("003", new Account("003", "Bala", 1500));

        accounts.get("001").deposit(500);
        accounts.get("002").withdraw(1000);

        List<Account> richAccounts = new ArrayList<>();
        for (Account acc : accounts.values()) {
            if (acc.getBalance() > 15000) {
                richAccounts.add(acc);
            }
        }

        System.out.println("Accounts with balance > 15000:");
        for (Account acc : richAccounts) {
            System.out.println(acc);
        }

        Set<String> sortedNames = new TreeSet<>();
        for (Account account : accounts.values()) {
            sortedNames.add(account.getHolderName());
        }

        System.out.println("Sorted Account Holder Names:");
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}

