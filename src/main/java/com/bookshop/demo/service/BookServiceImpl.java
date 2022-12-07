package com.bookshop.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.demo.entity.Books;
import com.bookshop.demo.entity.Orders;
import com.bookshop.demo.exception.BookNotFound;
import com.bookshop.demo.repository.BookRepository;
import com.bookshop.demo.repository.OrderRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void addBook(Books book) {

		bookRepository.save(book);
	}

	@Override
	public List<Books> getAllBooks() {

		return bookRepository.findAll();
	}

	@Override
	public Optional<Books> getBookByBookId(int bookId) throws BookNotFound {

		return bookRepository.findById(bookId);
	}

	@Override
	public void deleteBookByBookId(int bookId) throws BookNotFound {
		if (!bookRepository.existsById(bookId)) {
			throw new BookNotFound(bookId);
		}
		bookRepository.deleteById(bookId);

	}

//	Update Book  
	@Override
	public void updateBook(Books book) {
		Books books = bookRepository.findById(book.getBookId()).get();
		String name = book.getBookName();
		double price = book.getBookPrice();
		String authorName = book.getAuthorName();
		if (name != null) {
			books.setBookName(name);
		}

		if (price != 0) {
			books.setBookPrice(price);
		}
		if (authorName != null) {
			books.setAuthorName(authorName);
		}

		bookRepository.save(books);
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}

}
