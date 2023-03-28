package com.cartsy.ecom.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.*;


import com.cartsy.ecom.model.*;
import com.cartsy.ecom.repository.ProductRepository;

import java.util.*;

@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository repo;
   
    @PostMapping("/product") 
    public boolean create(@RequestBody Product product ){
        try {
            repo.save(product);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{

        }

    }

    @GetMapping("/product")
    public List<Product> read(){
        try {
            return repo.findAll();
            
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<Product>();
        }finally{

        }
    }

    @GetMapping("/product/{id}")
    public Optional<Product> read(@PathVariable Long id){
        try {
            return repo.findById(id);
            
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }finally{

        }
    }

    @PutMapping("/product")
    public boolean update(@RequestBody Product product){
        try {
            repo.save(product);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{

        }

    }

    @DeleteMapping("/product")
    public boolean delete(Product product){
        try {
            repo.delete(product);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{

        }

    }
}
