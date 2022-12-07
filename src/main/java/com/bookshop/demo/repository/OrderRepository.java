package com.bookshop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.demo.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
