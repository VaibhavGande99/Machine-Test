package com.machinetest.service;

import java.util.Optional;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.machinetest.entity.Product;

@Service
public interface ProductService {
	Page<Product> getAllProducts(Pageable pageable);
	Product createProduct(Product product);
	Optional<Product> getProductById(Long id);
	Product updateProductById(Long id, Product product);
	void deleteProductById(Long id);
}
