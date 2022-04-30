package app.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.grocery.entities.Customer;
import app.grocery.entities.Delivery;
import app.grocery.repository.CustomerRepository;
import app.grocery.repository.DeliveryRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/grocery/v1")
public class DeliveryController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	DeliveryRepository deliveryRepo;

	
	@PostMapping("/adddelivery")
	public Delivery addDelivery(@RequestBody Delivery delivery)
	{
		Customer customer=customerRepo.findById(delivery.getCustomer().getCustomerId()).get();
		
		if(customer!=null)
		{
			delivery.setCustomer(customer);
			return deliveryRepo.save(delivery);
		}
		else
		{
			return null;
		}
		
	}
	
	@GetMapping("/findbydeliveryid/{deliveryId}")
	public Delivery findByDeliveryId(@PathVariable("deliveryId")long deliveryId)
	{
		Optional<Delivery> delivery=deliveryRepo.findById(deliveryId);
		if(delivery.isPresent())
		{
			return delivery.get();
		}
		return null;
				
	}
	
	
	@GetMapping("/finddeliverybycustomerid/{customerId}")
	public List<Delivery> finddeliverybycustomerid(@PathVariable("customerId")long customerId)
	{
		
		return (List<Delivery>) deliveryRepo.getAllDeliveryByCustomerId(customerId);
				
	}
	
	@GetMapping("/findalldelivery")
	public List<Delivery> findAllDelivery()
	{
	  return (List<Delivery>)deliveryRepo.findAll();
				
	}
	
	@PutMapping("/updatedeliverystatus/{deliveryId}")
	public Delivery updateDeliveryStatus(@PathVariable("deliveryId") long deliveryId,@RequestBody  Delivery delivery)
	{
	 Delivery d=deliveryRepo.findById(deliveryId).get(); 	
	 d.setDeliveryStatus(delivery.getDeliveryStatus());
	 
	 return deliveryRepo.save(d);
	}
	
	
}
