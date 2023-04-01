package com.cartsy.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartsy.ecom.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long>{

}
