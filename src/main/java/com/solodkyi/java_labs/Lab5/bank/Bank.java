package com.solodkyi.java_labs.Lab5.bank;

import java.util.ArrayList;
import java.util.List;

import com.solodkyi.java_labs.Lab5.exceptions.AccountNotFoundException;
import com.solodkyi.java_labs.Lab5.exceptions.InsufficientFundsException;
import com.solodkyi.java_labs.Lab5.exceptions.NegativeAmountException;
import com.solodkyi.java_labs.Lab5.bankAccount.BankAccount;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        if(initialDeposit < 0) throw new NegativeAmountException("Negative initial deposit value: " + initialDeposit);
        
        BankAccount newAccount = new BankAccount(accounts.size() + 1, accountName, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found with account number: " + accountNumber);
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
