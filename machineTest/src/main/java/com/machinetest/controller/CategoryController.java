package com.machinetest.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machinetest.entity.Category;
import com.machinetest.service.CategoryService;



@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
  @PostMapping
  public int saveCategory(@RequestBody Category category)
  {
	  categoryService.saveCategory(category);
	  return 1;
  }
  
  @GetMapping
  public ResponseEntity<Page<Category>> getAllCategories(Pageable pageable) {
      return ResponseEntity.ok(categoryService.getAllCategories(pageable));
  }
   
   @GetMapping("/{id}")
   public Optional<Category> getByid(@PathVariable Long id)
   {
	   return categoryService.getbyId(id);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category) {
       Optional<Category> existingCategory = categoryService.getbyId(id);
       if (existingCategory.isPresent()) {
           category.setId(id); // Ensure the ID is set for the update
           categoryService.saveCategory(category);
           return ResponseEntity.ok("Category updated successfully");
       } else {
           return ResponseEntity.status(404).body("Category not found with ID: " + id);
       }
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteById(@PathVariable Long id)
   {
	   Optional<Category> existingCategory = categoryService.getbyId(id);
       if (existingCategory.isPresent()) {
    	   
    	   categoryService.deleteCategoryById(id);
    	   return ResponseEntity.ok("Deleted Successfully");
       }
       else
       {
    	   return ResponseEntity.status(404).body("Category bot available");
       }
	  
	  
   }
}
