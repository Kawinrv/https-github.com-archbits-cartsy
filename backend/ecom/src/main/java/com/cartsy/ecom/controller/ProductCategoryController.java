package com.cartsy.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartsy.ecom.model.ProductCategory;
import com.cartsy.ecom.repository.ProductCategoryRepository;

@RestController
public class ProductCategoryController {
	
	final static Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

	@Autowired
	ProductCategoryRepository repo;
	
	@PostMapping("/productcategory") 
    public boolean create(@RequestBody ProductCategory productCategory ){
        try {
            repo.save(productCategory);
            return true;
        }catch(Exception e){
            logger.error("Error occured",e);
            return false;
        }finally{

        }

    }
	
	@GetMapping("/productcategory")
	public List<ProductCategory> read(){
		try {
			return repo.findAll();
		}catch(Exception e) {
			logger.error("Error occured",e);
			return new ArrayList<>();
		}
	}
	

}
