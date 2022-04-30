package org.grocery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@RequestMapping("/productlist")
	public String listOfProduct()
	{
		
		return "admin/products-list";
		
	}
	

	@RequestMapping("/addproduct")
	public String addProduct()
	{
		
		return "admin/add-product";
		
	}
	 	
	@RequestMapping("/updateproduct/{productId}")
	public ModelAndView updateProduct(@PathVariable("productId") long productId)
	{
		
		Map<String,Integer> model=new HashMap<String,Integer>();
		model.put("productId",(int) productId);
		return new ModelAndView("admin/update-product",model);	
		
	}
	
	
}
