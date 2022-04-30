package app.grocery.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.grocery.entities.OrderedProducts;
import app.grocery.repository.OrderRepository;
import app.grocery.repository.OrderedProductRepository;
import app.grocery.service.OrderedProductsService;

@Service
public class OrderedProductsImpl implements OrderedProductsService{

	@Autowired
	OrderRepository orderRepo;
    
	@Autowired
	OrderedProductRepository orderedProductRepo;

	@Override
	public OrderedProducts getOrderedProductsByOrderId(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
