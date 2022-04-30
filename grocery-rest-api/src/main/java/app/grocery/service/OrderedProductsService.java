package app.grocery.service;

import app.grocery.entities.OrderedProducts;

public interface OrderedProductsService {
	
	public OrderedProducts getOrderedProductsByOrderId(long orderId); 

}
