package com.solodkyi.java_labs.Lab5Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab5.bank.*;
import com.solodkyi.java_labs.Lab5.bankAccount.*;
import com.solodkyi.java_labs.Lab5.exceptions.*;


class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccount() throws NegativeAmountException {
        BankAccount account = bank.createAccount("Jeb", 250);
        assertNotNull(account);
        assertEquals(250, account.getBalance());
    }

    @Test
    public void testFindAccount() throws NegativeAmountException, AccountNotFoundException {
        BankAccount createdAccount = bank.createAccount("Olaf", 25210);
        int accountNumber = createdAccount.getAccountNumber();
        BankAccount foundAccount = bank.findAccount(accountNumber);
        assertEquals(createdAccount, foundAccount);
    }

    @Test
    public void testTransferMoney() throws NegativeAmountException, AccountNotFoundException, InsufficientFundsException {
        BankAccount account1 = bank.createAccount("Bill", 60);
        BankAccount account2 = bank.createAccount("Bob", 30);

        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 15);

        assertEquals(45, account1.getBalance());
        assertEquals(45, account2.getBalance());
    }
    
    @Test
    public void testNegativeAmountExceptionOnCreateAccount() {
        assertThrows(NegativeAmountException.class, () -> bank.createAccount("Bob", -25));
    }
    
    @Test
    public void testAccountNotFoundException() {
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount(120));
    }



    @Test
    public void testInsufficientFundsExceptionOnTransferMoney() throws NegativeAmountException {
        BankAccount account1 = bank.createAccount("Bill", 600);
        BankAccount account2 = bank.createAccount("Bob", 100);

        assertThrows(InsufficientFundsException.class, () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 850));
    }

    @Test
    public void testNegativeAmountExceptionOnTransferMoney() throws NegativeAmountException {
        BankAccount account1 = bank.createAccount("Bill", 100);
        BankAccount account2 = bank.createAccount("Bob", 200);

        assertThrows(NegativeAmountException.class, () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), -100));
    }
}
