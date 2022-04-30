package app.grocery.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.grocery.entities.Category;
import app.grocery.entities.Product;
import app.grocery.entities.Seller;
import app.grocery.implementation.CategoryImpl;
import app.grocery.repository.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/grocery/v1")
public class CategoryController {

	@Autowired
	CategoryImpl categoryDao;
	@Autowired
	CategoryRepository categoryRepo;
	
	  
	  @GetMapping("/categories") 
	  public List<Category> getCategories() 
	  {
	  
	  return categoryDao.getcategories();
	  }
	  
	  
	  @GetMapping("/category/{categoryId}") 
	  public Category getProduct(@PathVariable("categoryId")long categoryId) 
	  {
	  
	  return categoryDao.getCategory(categoryId);
	  
	  }
	  
	  @Transactional
	  @PostMapping("/addcategory") 
	  public Category addCategory(@RequestBody Category category) 
	  {
		  return categoryDao.addCategory(category);
	  }
	  
	  @GetMapping("/getcategory/{categoryId}")
	  public Category getCategory(@PathVariable("categoryId") long categoryId)
	  {
		  return categoryDao.getCategory(categoryId);
	  }
	 
	  
	  
	  @CrossOrigin
	  @PutMapping("/updatecategory/{categoryId}")
	  public Category updateCategory(@RequestBody Category category,@PathVariable("categoryId") long categoryId)
	  {
		  
		  return categoryDao.updateCategory(categoryId, category);
		  
	  }
	  
	  @CrossOrigin
	  @DeleteMapping("/deletecategory/{categoryId}")
	  public void deleteCategory(@PathVariable("categoryId")long categoryId)
	  {
		  categoryRepo.deleteById(categoryId);
	  }
}
