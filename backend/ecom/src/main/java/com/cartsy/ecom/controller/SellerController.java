package com.cartsy.ecom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartsy.ecom.model.Seller;
import com.cartsy.ecom.repository.SellerRepository;

@RestController
public class SellerController {
	
	final static Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	SellerRepository repo;
	
	@PostMapping("/seller")
	public boolean create(@RequestBody Seller seller) {
		try {
			repo.save(seller);
			return true;
		}catch(Exception e) {
			logger.error("Error occured",e);
			return false;
		}
	}
	
	
	@GetMapping("/seller")
	public List<Seller> read(){
		try {
			return repo.findAll();
			
		}catch(Exception e) {
			logger.error("Error occured",e);
			return new ArrayList<Seller>();
			
		}
		
	}
	
	@GetMapping("/seller/{id}")
	public Optional<Seller> read(@PathVariable Long id){
		try {
			return repo.findById(id);
			
		}catch(Exception e) {
			logger.error("Error occured",e);
			return Optional.empty();
			
		}
		
	}
	
	@PutMapping("/seller/{id}")
	public boolean update(@RequestBody Seller seller){
		try {
			repo.save(seller);
			return true;
			
		}catch(Exception e) {
			logger.error("Error occured",e);
			return false;
			
		}
		
	}
	
	 @DeleteMapping("/seller")
	    public boolean delete(Seller seller){
	        try {
	            repo.delete(seller);
	            return true;
	        }catch(Exception e){
	            logger.error("Error occured",e);
	            return false;
	        }finally{

	        }

	    }
	

}
