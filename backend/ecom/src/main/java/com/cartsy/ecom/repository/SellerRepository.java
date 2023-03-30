package com.cartsy.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartsy.ecom.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
