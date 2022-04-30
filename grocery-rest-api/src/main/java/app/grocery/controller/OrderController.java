package app.grocery.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.grocery.entities.Customer;
import app.grocery.entities.Order;
import app.grocery.repository.CustomerRepository;
import app.grocery.repository.OrderRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/grocery/v1")
public class OrderController {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	@PostMapping("/addorder")
	public Order createOrder(@RequestBody Order order)
	{
		
		Customer customer=customerRepo.findById(order.getCustomer().getCustomerId()).get(); 

		order.setCustomer(customer);
		
		return orderRepo.save(order);
	}
	
	
	@GetMapping("/getorderbyid/{orderID}")
	public Order getOrderByOrderId(@PathVariable("orderID") long orderID )	
	{
		Order order= orderRepo.findById(orderID).get();
		if(order!=null)
		{
			return order;
		}
		else
		{
			return null;
		}
	}
	
	
	
	
	
}
