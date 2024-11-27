package com.machinetest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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

import com.machinetest.entity.Product;
import com.machinetest.service.ProductService;



@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

	@Autowired(required = true)
	ProductService productService;
	
	
	 @GetMapping
	    public ResponseEntity<Page<Product>> getAllProducts(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        Page<Product> products = (Page<Product>) productService.getAllProducts(PageRequest.of(page, size));
	        return ResponseEntity.ok(products);
	    }
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	    Product savedProduct = productService.createProduct(product); // Save product using service
	    return ResponseEntity.ok(savedProduct); // Return the saved product
	}

	
	 @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Optional<Product> product = productService.getProductById(id);
	        if (product.isPresent()) {
	            return ResponseEntity.ok(product.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProductById(
	            @PathVariable Long id,
	            @RequestBody Product product) {
	        try {
	            Product updatedProduct = productService.updateProductById(id, product);
	            return ResponseEntity.ok(updatedProduct);
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
	        try {
	            productService.deleteProductById(id);
	            return ResponseEntity.ok("Product deleted successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        
	 }
	 
	 
	 

}
