package com.solodkyi.java_labs.Lab5.exceptions;

public class AccountNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
        super(message);
    }
}
