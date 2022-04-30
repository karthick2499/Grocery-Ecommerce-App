package app.grocery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
