package com.bookshop.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.exception.BookNotFound;
import com.bookshop.demo.repository.BookRepository;
import com.bookshop.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	private final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		logger.info("inside getAllBooks");
		return bookService.getAllBooks();
	}

	@GetMapping("/getBookById/{id}")
	public Optional<Books> getBookById(@PathVariable("id") int id) throws BookNotFound {
		logger.info("inside getBookById");
		return bookService.getBookByBookId(id);
	}

}
