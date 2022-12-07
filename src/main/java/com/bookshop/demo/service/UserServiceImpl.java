package com.bookshop.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.entity.Orders;
import com.bookshop.demo.entity.Users;
import com.bookshop.demo.exception.InvalidCredential;
import com.bookshop.demo.repository.BookRepository;
import com.bookshop.demo.repository.OrderRepository;
import com.bookshop.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Books getBookByName(String bookname) {

		return bookRepository.getBookByName(bookname);
	}

	@Override
	public void OrderBookByName(String name, int userId) {
		Books orderBook = bookRepository.getBookByName(name);
		Users newUser = userRepo.findById(userId).get();

		Orders order = new Orders();
		order.setBooks(orderBook);
		order.setUsers(newUser);
		order.setOrderId(1);
		order.setQtyOrdered(1);
		order.setTotalPrice(orderBook.getBookPrice());

		orderRepo.save(order);
	}

	@Override
	public List<Users> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public String userRegistration(Users user) throws InvalidCredential {
		if (user != null) {
			userRepo.save(user);
			return "Regsitration SUccesfully";
		} else
			return "Regestration Failed";
	}

	@Override
	public String login(String email, String password) throws InvalidCredential {
		if (email.equals(userRepo.getEmail(email)) && password.equals(userRepo.getPassword(password))) {
			return "Login Succesfull";
		} else {
			throw new InvalidCredential("Invalid Login Credential ");

		}

	}

}
