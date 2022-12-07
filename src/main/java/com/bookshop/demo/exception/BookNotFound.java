package com.bookshop.demo.exception;

public class BookNotFound extends RuntimeException {

	private String messsage;


	public BookNotFound(int bookId) {
		super("Could not find Book with id " + bookId);

	}

}
