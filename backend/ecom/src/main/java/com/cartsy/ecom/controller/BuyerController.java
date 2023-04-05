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

import com.cartsy.ecom.model.Buyer;
import com.cartsy.ecom.repository.BuyerRepository;

@RestController
public class BuyerController {
<<<<<<< HEAD

	@Autowired
	BuyerRepository repo;

=======
	
	@Autowired
	BuyerRepository repo;
	
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2
	@PostMapping("/buyer")
	public boolean create(@RequestBody Buyer buyer) {
		try {
			repo.save(buyer);
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

	@GetMapping("/buyer")
	public List<Buyer> read() {
		try {
			return repo.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Buyer>();

		}

	}

	@GetMapping("/buyer/{id}")
	public Optional<Buyer> read(@PathVariable Long id) {
		try {
			return repo.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();

		}

	}

	@PutMapping("/buyer/{id}")
	public boolean update(@RequestBody Buyer buyer) {
		try {
			repo.save(buyer);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@DeleteMapping("/buyer")
	public boolean delete(Buyer buyer) {
		try {
			repo.delete(buyer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

		}

	}
=======
	
	
	@GetMapping("/buyer")
	public List<Buyer> read(){
		try {
			return repo.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Buyer>();
			
		}
		
	}
	
	@GetMapping("/buyer/{id}")
	public Optional<Buyer> read(@PathVariable Long id){
		try {
			return repo.findById(id);
			
		}catch(Exception e) {
			e.printStackTrace();
			return Optional.empty();
			
		}
		
	}
	
	@PutMapping("/buyer/{id}")
	public boolean update(@RequestBody Buyer buyer){
		try {
			repo.save(buyer);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	 @DeleteMapping("/buyer")
    public boolean delete(Buyer buyer){
        try {
            repo.delete(buyer);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{

        }

    }
	
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2

}
