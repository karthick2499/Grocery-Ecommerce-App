package app.grocery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	//Derived method or custom finder method
	public Customer findBycustomerEmail(String customerEmail);
	
	

}
