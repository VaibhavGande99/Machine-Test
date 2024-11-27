package com.machinetest.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.machinetest.entity.Product;
import com.machinetest.repository.ProductRepository;
import com.machinetest.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}


	@Override
	public Optional<Product> getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}


	@Override
	public Product updateProductById(Long id, Product product) {
		Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setNameOfProduct(product.getNameOfProduct());
            updatedProduct.setDescriprtion(product.getDescriprtion());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setQuantity(product.getQuantity());
            return productRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
	}


	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}


	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		// TODO Auto-generated method stub
		
		
		return productRepository.findAll(pageable);
	}

}
