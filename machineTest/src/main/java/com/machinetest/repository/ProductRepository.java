package com.machinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machinetest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
