package com.machinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.machinetest.entity.Category;

@Service
public interface CategoryService {

	
	 void saveCategory(Category category);
	 Page<Category> getAllCategories(Pageable pageable);
	 List<Category> findAllCategory();
	 
	  Optional<Category> getbyId(Long id);
	  
	  Category updateCategory(Long id, Category category);
	  
	  void deleteCategoryById(Long id);
}

