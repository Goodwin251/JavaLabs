package com.solodkyi.java_labs.Lab5.exceptions;

public class NegativeAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public NegativeAmountException(String message) {
        super(message);
    }
}
