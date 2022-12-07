package com.bookshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookshop.demo.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

	@Query(value = "select * from bookshopdb.books where book_Name=?1", nativeQuery = true)
	public Books getBookByName(String bookName);

}
