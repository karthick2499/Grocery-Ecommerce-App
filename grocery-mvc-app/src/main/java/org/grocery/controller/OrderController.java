package org.grocery.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	
	
	@RequestMapping("/order-confirm")
	public String customerRegister()
	{
		return "customer/order-confirm";
		
	}
	
	
	
	@RequestMapping("/order-status/{orderId}")
	public ModelAndView viewOrderStatus(@PathVariable("orderId")long orderId )
	{
		Map<String,Integer> model=new HashMap<String,Integer>();
		model.put("orderId",(int) orderId);
		return new ModelAndView("customer/order-status",model);
		
		
	}
	
	@GetMapping("/getalldelivery")
	public String deliveryList()
	{
		
		return "admin/delivery-list";
	}


}
