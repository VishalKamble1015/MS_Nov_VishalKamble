package com.bookshop.demo.service;

import java.util.List;
import java.util.Optional;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.entity.Orders;
import com.bookshop.demo.exception.BookNotFound;

public interface BookService {

	public void addBook(Books book);

	public List<Books> getAllBooks();

	public Optional<Books> getBookByBookId(int bookId) throws BookNotFound;

	public void deleteBookByBookId(int bookId) throws BookNotFound;

	public void updateBook(Books b1);

	public List<Orders> getAllOrders();

}
