package com.bookshop.demo.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Value(value = "${data.exception.message1}")
	private String message1;
	@Value(value = "${data.exception.message2}")
	private String message2;

	@ExceptionHandler(value = BookNotFound.class)
	public ResponseEntity<String> EmployeeNotFound(BookNotFound bookNotFound) {
		return new ResponseEntity<String>(message1, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidCredential.class)
	public ResponseEntity<String> InvalidUserCredential(InvalidCredential invalidUserCredential) {
		return new ResponseEntity<String>(message2, HttpStatus.NOT_FOUND);
	}

}
