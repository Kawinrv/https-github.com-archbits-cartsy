package com.cartsy.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cartsy.ecom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{}