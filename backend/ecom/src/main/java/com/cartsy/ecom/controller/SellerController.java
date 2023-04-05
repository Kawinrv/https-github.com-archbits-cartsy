package com.cartsy.ecom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
<<<<<<< HEAD

	@Autowired
	SellerRepository repo;

=======
	
	@Autowired
	SellerRepository repo;
	
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2
	@PostMapping("/seller")
	public boolean create(@RequestBody Seller seller) {
		try {
			repo.save(seller);
			return true;
<<<<<<< HEAD
		} catch (Exception e) {
=======
		}catch(Exception e) {
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2
			e.printStackTrace();
			return false;
		}
	}
<<<<<<< HEAD

	@GetMapping("/seller")
	public List<Seller> read() {
		try {
			return repo.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Seller>();

		}

	}

	@GetMapping("/seller/{id}")
	public Optional<Seller> read(@PathVariable Long id) {
		try {
			return repo.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();

		}

	}

	@PutMapping("/seller/{id}")
	public boolean update(@RequestBody Seller seller) {
		try {
			repo.save(seller);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@DeleteMapping("/seller")
	public boolean delete(Seller seller) {
		try {
			repo.delete(seller);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}

	}
=======
	
	
	@GetMapping("/seller")
	public List<Seller> read(){
		try {
			return repo.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Seller>();
			
		}
		
	}
	
	@GetMapping("/seller/{id}")
	public Optional<Seller> read(@PathVariable Long id){
		try {
			return repo.findById(id);
			
		}catch(Exception e) {
			e.printStackTrace();
			return Optional.empty();
			
		}
		
	}
	
	@PutMapping("/seller/{id}")
	public boolean update(@RequestBody Seller seller){
		try {
			repo.save(seller);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	 @DeleteMapping("/seller")
	    public boolean delete(Seller seller){
	        try {
	            repo.delete(seller);
	            return true;
	        }catch(Exception e){
	            e.printStackTrace();
	            return false;
	        }finally{

	        }

	    }
	
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2

}
