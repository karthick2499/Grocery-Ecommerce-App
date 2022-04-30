package app.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import app.grocery.entities.Order;
import app.grocery.entities.OrderedProducts;
import app.grocery.repository.OrderRepository;
import app.grocery.repository.OrderedProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/grocery/v1")
public class OrderedProductController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderedProductRepository orderedProductRepo;
	
	@PostMapping("/addorderedproducts")
	public OrderedProducts addOrderedProducts(@RequestBody OrderedProducts orderedproduct)
	{
		Order order=orderRepo.findById(orderedproduct.getOrder().getOrderId()).get();
		if(order!=null)
		{
			return orderedProductRepo.save(orderedproduct);
		}
		else
		{
			return null;
		}
		
	}
	
	
	@GetMapping("/findorderedproductsbyorderid/{orderId}")
	@JsonProperty
	public ResponseEntity<List<OrderedProducts>> findOrderedProductsByOrderId(@PathVariable("orderId") long orderId)
	{
		List<OrderedProducts> orderedProducts=(List<OrderedProducts>) orderedProductRepo.findByOrderId(orderId);
		return  ResponseEntity.ok().body(orderedProducts);
		
	}
	

}
