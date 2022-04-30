package org.grocery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {
	
	
	@RequestMapping("/customer-register")
	public String customerRegister()
	{
		return "customer/registration";
		
	}
	
	
	@RequestMapping("/customer-login")
	public String customerLogin()
	{
		return "customer/login";
		
	}
	@RequestMapping("/orders")
	public String getAllOrderDetails()
	{
		return "customer/order-list";
	}
	
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "customer/login";
	}

}
