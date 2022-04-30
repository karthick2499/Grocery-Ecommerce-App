package app.grocery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.grocery.entities.Category;
import app.grocery.entities.Customer;
import app.grocery.entities.Order;
import app.grocery.entities.Seller;
import app.grocery.repository.CustomerRepository;
import app.grocery.repository.OrderRepository;
import app.grocery.repository.SellerRepository;

@SpringBootApplication
public class GroceryEcommerceAppApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(GroceryEcommerceAppApplication.class, args);
		

	
		
		
		
	}	
}
