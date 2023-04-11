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

import com.cartsy.ecom.model.Buyer;
import com.cartsy.ecom.repository.BuyerRepository;

@RestController
public class BuyerController {
	
	final static Logger logger = LoggerFactory.getLogger(BuyerController.class);

	
	@Autowired
	BuyerRepository repo;
	
	@PostMapping("/buyer")
	public boolean create(@RequestBody Buyer buyer) {
		try {
			repo.save(buyer);
			return true;
		}catch(Exception e) {
			logger.error("Error occured",e);
			return false;
		}
	}
	
	
	@GetMapping("/buyer")
	public List<Buyer> read(){
		try {
			return repo.findAll();
			
		}catch(Exception e) {
			logger.error("Error occured",e);
			return new ArrayList<Buyer>();
			
		}
		
	}
	
	@GetMapping("/buyer/{id}")
	public Optional<Buyer> read(@PathVariable Long id){
		try {
			return repo.findById(id);
			
		}catch(Exception e) {
			logger.error("Error occured",e);
			return Optional.empty();
			
		}
		
	}
	
	@PutMapping("/buyer/{id}")
	public boolean update(@RequestBody Buyer buyer){
		try {
			repo.save(buyer);
			return true;
			
		}catch(Exception e) {
			logger.error("Error occured",e);
			return false;
			
		}
		
	}
	
	 @DeleteMapping("/buyer")
    public boolean delete(Buyer buyer){
        try {
            repo.delete(buyer);
            return true;
        }catch(Exception e){
            logger.error("Error occured",e);
            return false;
        }finally{

        }

    }
	

}
