package app.grocery;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.grocery.entities.Customer;
import app.grocery.entities.Order;
import app.grocery.entities.Transaction;
import app.grocery.repository.CategoryRepository;
import app.grocery.repository.CustomerRepository;
import app.grocery.repository.OrderRepository;
import app.grocery.repository.SellerRepository;
import app.grocery.repository.TransactionRepository;

@SpringBootTest
class GroceryEcommerceAppApplicationTests {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	TransactionRepository trepo;
	
	@Autowired
	CategoryRepository categoryrepo;
	
	@Autowired
	SellerRepository sellerrepo;
	
	//@Test
	/*
	 * public void customerSave() { Customer customer=new
	 * Customer("raman",987656456,"kolkata","raman@gmail.com"); Order order=new
	 * Order();
	 * 
	 * customerRepo.save(customer);
	 * 
	 * }
	 */
	
	//@Test
	public void getAllCustomers()
	{
		List<Customer> clist=(List<Customer>) customerRepo.findAll();
		for(Customer c:clist)
		{
			System.out.println(c.getCustomerId());
			System.out.println(c.getCustomerAddress());
			
		}
	}
	/*
	 * @Test public void saveOrder() {
	 * 
	 * Order order1=new Order(); Date normalDate1=new Date(); java.sql.Date
	 * sqlDate1=new java.sql.Date(normalDate1.getTime());
	 * 
	 * order1.setOrderdate(sqlDate1); order1.setCustomer(customerRepo.findById(new
	 * Long(1)).get());
	 * 
	 * 
	 * 
	 * Order order2=new Order(); Date normalDate2=new Date(); java.sql.Date
	 * sqlDate2=new java.sql.Date(normalDate2.getTime());
	 * 
	 * order2.setOrderdate(sqlDate2); order2.setCustomer(customerRepo.findById(new
	 * Long(1)).get());
	 * 
	 * orderRepo.save(order1); orderRepo.save(order2);
	 * 
	 * }
	 */
	

	
}
