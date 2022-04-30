package app.grocery.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.grocery.entities.Customer;
import app.grocery.repository.CustomerRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/grocery/v1")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;
	
	@GetMapping("/findcustomer/{customerId}")
	public Customer findbyCustoemrId(@PathVariable("customerId")long customerId)
	{
		Optional<Customer> customer=customerRepo.findById(customerId);
		if(customer.isPresent())
		{
			return customer.get();
		}
		else
		{
			return null;
		}
		
	}
	
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerRepo.save(customer);
	}
	
	
	@GetMapping("/getcustomerbyemail")
	public Customer findCustomerByEmail(@RequestParam("email") String email)
	{
		
		return customerRepo.findBycustomerEmail(email);
	}
	
	
}
