package org.grocery.controller;

import java.util.Optional;

import org.grocery.Admin;
import org.grocery.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@Autowired
	AdminRepository adminRepo;
	
	@RequestMapping("/admin")
	public String adminLogin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin", admin);
		return "admin/login";
		
	}
	
	@RequestMapping("/formprocess")
	public String formProcess(@ModelAttribute("admin")Admin admin)
	{
	 String email=admin.getEmail();	
	 String password=admin.getPassword();
	 System.out.print(password+" "+email);
	 
	 Optional<Admin> adminObject=adminRepo.findById(email);
	 if(adminObject.isPresent())
	 {
		 if(password.equals(adminObject.get().getPassword()))
		 {
			 return "admin/index";
		 }
		 else
		 {
			 return "admin/login";
		 }
	 }
	 return "admin/login";
	}
	 
	@RequestMapping("/admin-logout")
	public String logout()
	{
		return "redirect:/admin";
		
	}
	 
	

}
