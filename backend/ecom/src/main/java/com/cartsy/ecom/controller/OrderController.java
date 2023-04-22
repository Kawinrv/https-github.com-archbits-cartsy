package com.cartsy.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cartsy.ecom.model.Order;
import com.cartsy.ecom.model.RestResponse;
import com.cartsy.ecom.repository.OrderRepository;

@RestController
public class OrderController { // Vidhur

	final static Logger logger = LoggerFactory.getLogger(ProductController.class);
	final static ObjectMapper mapper = new ObjectMapper();
	@Autowired
	OrderRepository repo;

	@PostMapping("/order")
	public ResponseEntity create(@RequestBody Order order) {
		try {
			logger.info("Creating new order...");

			repo.save(order);

			logger.info("Successfully created a new order.");

			logger.debug("Successfully created a new Order. Order details: " + mapper.writeValueAsString(order));

			return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(200, "Success!", "", ""));
		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}

	@GetMapping("/order/search")
	public List<Order> readBySearch(@RequestParam String searchText) {

		try {

			return repo.search(searchText);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return new ArrayList<Order>();
		} finally {

		}
	}

	@PutMapping("/order/{id}")
	public boolean update(@RequestBody Order order) {
		try {
			repo.save(order);
			return true;

		} catch (Exception e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
			return false;

		}

	}

	@DeleteMapping("/order")
	public boolean delete(Order order) {
		try {
			repo.delete(order);
			return true;
		} catch (Exception e) {
			logger.error("Error occurred", e);
			e.printStackTrace();
			return false;
		} finally {

		}

	}

}
