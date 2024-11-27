package com.machinetest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.machinetest.entity.Category;
import com.machinetest.repository.CategoryRepository;
import com.machinetest.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> getbyId(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		// TODO Auto-generated method stub
		
		
		 Optional<Category> optionalCategory = categoryRepository.findById(id);

	        if (optionalCategory.isPresent()) {
	            Category existingCategory = optionalCategory.get();

	           
	            existingCategory.setName(category.getName());
	            

	           
	            return categoryRepository.save(existingCategory);
	        } else {
	            throw new RuntimeException("Category not found with ID: " + id);
	        }
	    }

	@Override
	public void deleteCategoryById(Long id) {
		// TODO Auto-generated method stub
		
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		// TODO Auto-generated method stub
		return  categoryRepository.findAll(pageable);
	}
	}


	
	

	

	

	
	

	
	


