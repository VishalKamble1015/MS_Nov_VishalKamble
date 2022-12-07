package com.bookshop.demo.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookshop.demo.constants.Category;
import com.bookshop.demo.entity.Books;
import com.bookshop.demo.repository.BookRepository;
import com.bookshop.demo.service.BookServiceImpl;

@SpringBootTest(classes= {BookServiceTest.class})
public class BookServiceTest {

	@Mock
	BookRepository bookRepo;
	
	@InjectMocks
	BookServiceImpl bookServImpl;
	
	public List<Books> bookList;
	
	@Test
	public void test_getAllBooks() {
		List<Books> bookList1 =new ArrayList<>();
		bookList1.add(new Books(1,"Rich Dad Poor Dad",335.0,Category.EDUCATIONAL,"Robert Kiyosaki"));
		bookList1.add(new Books(2,"ikigai",399.0,Category.NOVEL,"Hector Garcia"));
		
		when(bookRepo.findAll()).thenReturn(bookList1);
		
		Assertions.assertEquals(2, bookServImpl.getAllBooks().size());
	}
}
