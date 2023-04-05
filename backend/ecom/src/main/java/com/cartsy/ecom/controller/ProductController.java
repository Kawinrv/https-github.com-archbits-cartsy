package com.cartsy.ecom.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;<<<<<<<HEAD
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @PostMapping("/product")
    public boolean create(@RequestBody Product product) {
        try {
            repo.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {

        }

    }

    @GetMapping("/product")
    public List<Product> read() {
        try {
            return repo.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Product>();
        } finally {

        }
    }<<<<<<<HEAD

    @GetMapping("/product/{id}")

    public Product read(@PathVariable Long id){
        try {
            Optional<Product> product = repo.findById(id);
            return product.get();
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
=======

    @GetMapping("/product/page")
    public List<Product> readByPage(@RequestParam Integer pageNo, @RequestParam(required = false) Integer pageSize) {
        int PAGE_SIZE = pageSize != null ? pageSize : 100;
        try {
            Pageable page = PageRequest.of(pageNo, PAGE_SIZE);
            return repo.findAll(page).getContent();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Product>();
        } finally {

        }
    }

    @GetMapping("/product/search")
    public List<Product> readBySearch(@RequestParam String searchText) {

        try {

            return repo.search(searchText);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Product>();
        } finally {

        }
    }

    @GetMapping("/product/category")
    public List<Product> readByCategory(@RequestParam Integer category) {

        try {

            return repo.filterByCategory(category);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Product>();
        } finally {

        }
    }

    @GetMapping("/product/{id}/recommended")
    public List<Product> readByRecommendation(@PathVariable Integer id) {

        try {

            // read the product's category
            Optional<Product> p = repo.findById(id);
            if (p.isPresent()) {
                return repo.recommendation(p.get().getCategory_id());
            }
            return new ArrayList<Product>();

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Product>();
        } finally {

        }
    }

    @GetMapping("/product/{id}")
    public Optional<Product> readById(@PathVariable Integer id){
        try {
            return repo.findById(id);
            
        }catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2
        }finally{

        }
    }

    @PutMapping("/product")
    public boolean update(@RequestBody Product product) {
        try {
            repo.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {

        }

    }

    @DeleteMapping("/product")
    public boolean delete(Product product) {
        try {
            repo.delete(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {

        }

    }
}
