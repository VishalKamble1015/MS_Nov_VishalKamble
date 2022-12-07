package com.bookshop.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.entity.Orders;
import com.bookshop.demo.entity.Users;
import com.bookshop.demo.exception.BookNotFound;
import com.bookshop.demo.service.BookService;
import com.bookshop.demo.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	//Using Logger
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserService userservice;
	@Autowired
	private BookService bookService;

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {

		logger.info("inside getAllUsers");
		return userservice.getAllUsers();

	}

	@PutMapping("/updateBook")
	public void updateBook(@RequestBody Books book) {
		logger.info("inside updateBook");
		bookService.updateBook(book);
	}

	@PostMapping("/addBook")
	public void addBook(@RequestBody Books book) {
		logger.info("inside addBook");
		System.out.println("inside addBook");
		bookService.addBook(book);
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int bookId) {
		try {
			logger.info("inside deleteBook");
			bookService.deleteBookByBookId(bookId);
			return "deleted succesfully";
		} catch (BookNotFound ex) {
			return "Book not found";
		}
	}

	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders() {
		return bookService.getAllOrders();
	}

}
