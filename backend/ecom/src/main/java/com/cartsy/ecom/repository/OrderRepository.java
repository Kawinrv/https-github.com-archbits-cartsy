package com.cartsy.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartsy.ecom.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
