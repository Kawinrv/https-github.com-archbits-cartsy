package com.cartsy.ecom.api.v1.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cartsy.ecom.api.v1.model.Cart;
import com.cartsy.ecom.api.v1.model.RestResponse;
import com.cartsy.ecom.repository.CartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
public class CartController {
	
	final static Logger logger = LoggerFactory.getLogger(CartController.class);
	final static ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private CartRepository repo;

	@PostMapping("private/buyers/cart/{cartId}")
	public ResponseEntity addItem(@PathVariable Integer cartId, @RequestParam Integer productId) {
		try {
			logger.info("Adding item to cart...");

			Optional<Cart> cart = repo.findById(cartId);
			
			if(cart.isPresent()) {
			String products = cart.get().getProducts();
			
			if(products!=null && !products.isEmpty()) {
				products = products.concat(","+productId);
				
			}else {
				products = String.valueOf(productId);
			}
			
			
			cart.get().setProducts(products);
			repo.save(cart.get());

			logger.info("Successfully added a new item into the cart");
			}
			return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(200, "Success!", "", ""));
		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}



	@GetMapping("private/buyers/cart/{id}")
	public ResponseEntity get(@PathVariable Integer id) {
		logger.info("Fetching cart...");

		try {
			Optional<Cart> cart = repo.findById(id);
			
			return ResponseEntity.status(HttpStatus.OK).body(cart.get());
		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}
	
	@DeleteMapping("private/buyers/cart/{cartId}")
	public ResponseEntity delete(@PathVariable Integer cartId, @RequestParam Integer productId) {
		try {
			logger.info("Deleting item from cart...");

			Optional<Cart> cart = repo.findById(cartId);
			
			if(cart.isPresent()) {
				String products = cart.get().getProducts();
				
				if(products!=null && !products.isEmpty()) {
					String[] productArr = products.split(",");
					List<String> updated = Arrays.asList(productArr);
					updated.removeIf(element -> (element.equals(String.valueOf(productId))));
					
					String updatedProducts ="";
					for(String s: updated) {
						updatedProducts.concat(s + ",");
						
					}
					
				}
			}

			logger.info("Successfully deleted item from the cart");

			return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(200, "Success!", "", ""));
		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}



}
