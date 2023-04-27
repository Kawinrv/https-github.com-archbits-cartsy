package com.cartsy.ecom.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cartsy.ecom.api.v1.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.productSDesc LIKE %:text% OR p.productLDesc LIKE %:text% OR p.brand LIKE %:text%")
	List<Product> search(@Param("text") String searchText );

	@Query("SELECT p FROM Product p WHERE p.categoryId = :category")
	List<Product> recommendation(@Param("category") Integer category);
	
	@Query("SELECT p FROM Product p WHERE p.categoryId = :category")
	List<Product> filterByCategory(@Param("category") Integer category);
	
	@Query("SELECT p FROM Product p WHERE p.sellerId = :sellerId")
	List<Product> filterBySeller(@Param("sellerId") Integer sellerId);
	
	@Query("SELECT p FROM Product p WHERE p.createdDate >= :creationDate")
	List<Product> filterByCreationDate(@Param("creationDate") Date creationDate);

	
}