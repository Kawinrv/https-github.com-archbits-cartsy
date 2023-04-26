package com.cartsy.ecom.api.v1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cartsy.ecom.api.v1.model.*;
import com.cartsy.ecom.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
public class ProductController {

	final static Logger logger = LoggerFactory.getLogger(ProductController.class);
	final static ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private ProductRepository repo;

	@PostMapping("private/products")
	public ResponseEntity create(@RequestBody Product product) {
		try {
			logger.info("Creating new product...");

			repo.save(product);

			logger.info("Successfully created a new product.");

			logger.debug("Successfully created a new product. Product details: " + mapper.writeValueAsString(product));

			return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(200, "Success!", "", ""));
		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}

	@GetMapping("public/products")
	public ResponseEntity read() {
		try {
			logger.info("Reading all products...");
			List<Product> products = repo.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(products);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));

		} finally {

		}
	}

	@GetMapping("public/products/page")
	public ResponseEntity readByPage(@RequestParam Integer pageNo, @RequestParam(required = false) Integer pageSize) {
		logger.info("Reading paginated products...");

		int PAGE_SIZE = pageSize != null ? pageSize : 100;
		try {
			logger.debug("Reading paginated products. Page size :" + pageSize);

			Pageable page = PageRequest.of(pageNo, PAGE_SIZE);
			List<Product> products = repo.findAll(page).getContent();
			return ResponseEntity.status(HttpStatus.OK).body(products);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));

		} finally {

		}
	}

	@GetMapping("public/products/search")
	public ResponseEntity readBySearch(@RequestParam String searchText) {
		logger.info("Searching products...");

		try {

			logger.debug("Searching products. Search text :" + searchText);

			List<Product> products = repo.search(searchText);
			return ResponseEntity.status(HttpStatus.OK).body(products);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}
	}

	@GetMapping("public/products/category")
	public ResponseEntity readByCategory(@RequestParam Integer category) {
		logger.info("Reading products by category...");

		try {
			logger.debug("Reading products by category. CategoryId :" + category);

			List<Product> products = repo.filterByCategory(category);
			return ResponseEntity.status(HttpStatus.OK).body(products);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}
	}

	@GetMapping("public/products/{id}/recommended")
	public ResponseEntity readByRecommendation(@PathVariable Integer id) {

		logger.info("Reading products recommendation...");

		try {
			logger.debug("Reading products by recommendation. ProductId :" + id);

			// read the product's category
			Optional<Product> p = repo.findById(id);
			List<Product> products = new ArrayList<Product>();
			if (p.isPresent()) {
				products = repo.recommendation(p.get().getCategoryId());

			}
			return ResponseEntity.status(HttpStatus.OK).body(products);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}
	}

	@GetMapping("public/products/{id}")
	public ResponseEntity readById(@PathVariable Integer id) {
		logger.info("Reading product by Id...");

		try {
			logger.debug("Reading product by Id. ProductId :" + id);
			Product p = repo.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).body(p);

		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));

		} finally {

		}
	}

	@PutMapping("private/products/{id}")
	public ResponseEntity update(@PathVariable Integer id, @RequestBody Product product) {
		logger.info("Saving product...");

		try {
			logger.info("Saving product. ProductId :" + id);
			repo.save(product);
			return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(200, "Success!", "", ""));
		} catch (Exception e) {
			logger.error("Error occurred", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}

	@DeleteMapping("private/products/{id}")
	public ResponseEntity delete(@PathVariable Integer id, Product product) {
		logger.info("Deleting product...");

		try {
			logger.info("Deleting product. ProductId :" + id);
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(200, "Success!", "", ""));
		} catch (Exception e) {
			logger.error("Error occured", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RestResponse(500, "Failure!", "", e.getLocalizedMessage()));
		} finally {

		}

	}
}
