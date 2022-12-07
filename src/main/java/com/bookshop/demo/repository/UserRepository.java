package com.bookshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookshop.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query(value = "select email from bookshopdb.users where email=?1", nativeQuery = true)
	public String getEmail(String email);

	@Query(value = "select password from bookshopdb.users where password=?1", nativeQuery = true)
	public String getPassword(String password);

}
