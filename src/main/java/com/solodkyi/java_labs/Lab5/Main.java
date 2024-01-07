package com.solodkyi.java_labs.Lab5;

import com.solodkyi.java_labs.Lab5.bank.Bank;
import com.solodkyi.java_labs.Lab5.bankAccount.BankAccount;
import com.solodkyi.java_labs.Lab5.exceptions.AccountNotFoundException;
import com.solodkyi.java_labs.Lab5.exceptions.InsufficientFundsException;
import com.solodkyi.java_labs.Lab5.exceptions.NegativeAmountException;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        
        try {
            BankAccount account1 = bank.createAccount("Jeb", 200);
            account1.deposit(100);
            account1.withdraw(250);
            System.out.println(account1.getAccountSummary());
        } catch (NegativeAmountException | InsufficientFundsException e) {
            e.printStackTrace();
        }

        try {
            BankAccount account2 = bank.findAccount(2);
            System.out.println(account2.getAccountSummary());
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            BankAccount account3 = bank.createAccount("Kerman", 25);
            account3.withdraw(30);
        } catch (InsufficientFundsException | NegativeAmountException e) {
            System.out.println(e.getMessage());
        }

        try {
            BankAccount account3 = bank.createAccount("Bill", 700);
            account3.deposit(-400);
        } catch (NegativeAmountException e) {
            System.out.println(e.getMessage());
        }

        try {
            BankAccount account4 = bank.createAccount("Alice", 900);
            BankAccount account5 = bank.createAccount("Bob", 200);

            bank.transferMoney(account4.getAccountNumber(), account5.getAccountNumber(), 350);
            
            System.out.println(account4.getAccountSummary());
            System.out.println(account5.getAccountSummary());
        } catch (AccountNotFoundException | InsufficientFundsException | NegativeAmountException e) {
            e.printStackTrace();
        }
    }
}