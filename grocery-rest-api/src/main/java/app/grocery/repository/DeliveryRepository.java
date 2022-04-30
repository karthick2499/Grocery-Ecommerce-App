package app.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long>{
	
	@Query(value="SELECT * FROM Delivery  WHERE customer_id = ?1",nativeQuery = true)
	public List<Delivery> getAllDeliveryByCustomerId(long customerId);
	
	

}
