package com.cartsy.ecom.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import com.cartsy.ecom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{}
=======
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cartsy.ecom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.product_s_desc LIKE %:text% OR p.product_l_desc LIKE %:text% OR p.brand LIKE %:text%")
	List<Product> search(@Param("text") String searchText );

	@Query("SELECT p FROM Product p WHERE p.category_id = :category")
	List<Product> recommendation(@Param("category") Integer category);
	
	@Query("SELECT p FROM Product p WHERE p.category_id = :category")
	List<Product> filterByCategory(@Param("category") Integer category);

	
}
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2
