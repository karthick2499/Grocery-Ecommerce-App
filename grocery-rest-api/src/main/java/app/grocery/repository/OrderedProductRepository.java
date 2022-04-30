package app.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.grocery.entities.OrderedProducts;

@Repository
public interface OrderedProductRepository extends CrudRepository<OrderedProducts, Long> {
	
	@Query(value="SELECT * 	FROM ordered_products o WHERE o.order_id = :orderId",nativeQuery = true)
	public List<OrderedProducts> findByOrderId(@Param("orderId")long orderId); 

}
