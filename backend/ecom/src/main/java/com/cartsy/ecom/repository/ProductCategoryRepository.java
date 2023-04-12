package com.cartsy.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cartsy.ecom.model.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
