package com.bookshop.demo.exception;

public class InvalidCredential extends RuntimeException {

	public InvalidCredential(String msg) {
		super(msg);

	}

	public InvalidCredential() {

	}
}
