package com.cartsy.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cartsy.ecom.model.Order;
import com.cartsy.ecom.repository.OrderRepository;

@RestController
public class OrderController {  //Vidhur

    @Autowired
    OrderRepository repo;

    @PostMapping("/order")
	public boolean create(@RequestBody Order order) {
		try {
			repo.save(order);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

    @GetMapping("/order")
	public List<Order> read(){
		try {
			return repo.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Order>();
			
		}
		
	}

    @PutMapping("/order/{id}")
	public boolean update(@RequestBody Order order){
		try {
			repo.save(order);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

    @DeleteMapping("/order")
    public boolean delete(Order order){
        try {
            repo.delete(order);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{

        }

    }



}

