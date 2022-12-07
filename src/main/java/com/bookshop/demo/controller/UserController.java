package com.bookshop.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.entity.Users;
import com.bookshop.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userservice;

	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		logger.info("inside getAllBooks");
		return userservice.getAllBooks();
	};

	@GetMapping("/getBookByName/{name}")
	public Books getBookByName(@PathVariable("name") String bookName) {
		logger.info("inside getBookByName");
		return userservice.getBookByName(bookName);
	};

	@PostMapping("/register")
	public String userRegister(@Valid @RequestBody Users user) {
		logger.info("inside register");
		return userservice.userRegistration(user);
	}

	@PostMapping("/OrderBookByName")
	public void OrderBookByName(@RequestParam("name") String name, @RequestParam("userId") int userId) {
		logger.info("inside OrderBookByName");
		userservice.OrderBookByName(name, userId);
	};

	@GetMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		logger.info("inside login");
		return userservice.login(email, password);
	}

	
	//Validation error handling
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}

//	@GetMapping("/viewOrderDetails")
//	public List<Orders> viewOrderDetails(Users user){
//		return userservice.viewOrderDetails(user);
//	};

}
