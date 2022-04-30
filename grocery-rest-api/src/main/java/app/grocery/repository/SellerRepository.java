package app.grocery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Product;

import app.grocery.entities.Seller;
@Repository
public interface SellerRepository extends CrudRepository<Seller, Long>{

	

}
