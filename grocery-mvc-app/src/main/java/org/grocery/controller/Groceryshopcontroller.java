package org.grocery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Groceryshopcontroller {
	
	
	@RequestMapping("/groceryshop")
	public String groceryHome()
	{
		
		return "public/index";
		
	}
	
	@RequestMapping("/productsbycategory/{categoryId}")
	public ModelAndView viewProductsBycategory(@PathVariable("categoryId") long categoryId)
	{
		Map<String,Integer> model=new HashMap<String,Integer>();
		model.put("categoryId",(int) categoryId);
		return new ModelAndView("public/category-products",model);
		
		
	}
	
	
	@RequestMapping("/viewproduct/{productId}")
	public ModelAndView viewProductsByProductId(@PathVariable("productId") long productId)
	{
		Map<String,Integer> model=new HashMap<String,Integer>();
		model.put("productId",(int) productId);
		return new ModelAndView("public/single-product",model);	
	}
	
	@RequestMapping("/cartproducts")
	public String cartproducts()
	{
		return "public/cart-products";
	}
	
	@RequestMapping("/placeorder")
	public String checkout()
	{
		return "public/checkout";
	}
	
	
}
