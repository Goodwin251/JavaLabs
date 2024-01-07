package com.solodkyi.java_labs.Lab5Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab5.bankAccount.*;
import com.solodkyi.java_labs.Lab5.exceptions.*;


public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {

        account = new BankAccount(20, "Jeb", 100);
    }

    @Test
    public void testDeposit() throws NegativeAmountException {
        account.deposit(1000);
        assertEquals(1100, account.getBalance());
    }

    @Test
    public void testWithdraw() throws NegativeAmountException, InsufficientFundsException {
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testNegativeAmountExceptionOnDeposit() {
        assertThrows(NegativeAmountException.class, () -> account.deposit(-1));
    }
    
    @Test
    public void testInsufficientFundsExceptionOnWithdraw() {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(24070));
    }

    @Test
    public void testNegativeAmountExceptionOnWithdraw() {
        assertThrows(NegativeAmountException.class, () -> account.withdraw(-1));
    }
}
