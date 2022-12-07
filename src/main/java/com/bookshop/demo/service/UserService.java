package com.bookshop.demo.service;

import java.util.List;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.entity.Users;
import com.bookshop.demo.exception.InvalidCredential;

public interface UserService {

	public List<Books> getAllBooks();

	public Books getBookByName(String bookName);

	public void OrderBookByName(String name, int userId);

	public List<Users> getAllUsers();

	public String userRegistration(Users user) throws InvalidCredential;

	public String login(String email, String password) throws InvalidCredential;
}
