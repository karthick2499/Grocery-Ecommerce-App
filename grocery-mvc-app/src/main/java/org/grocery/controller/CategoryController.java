package org.grocery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CategoryController {

	

	@RequestMapping("/listcategory")
	public String listOfProduct()
	{
		
		return "admin/category-list";
		
	}
	

	@RequestMapping("/addcategory")
	public String addProduct()
	{
		
		return "admin/add-category";
		
	}
	
	
	
	 	
	@RequestMapping("/updatecategory/{categoryId}")
	public ModelAndView updateProduct(@PathVariable("categoryId") long categoryId)
	{
		
		Map<String,Integer> model=new HashMap<String,Integer>();
		model.put("categoryId",(int) categoryId);
		return new ModelAndView("admin/update-category",model);	
		
	}
	
}
