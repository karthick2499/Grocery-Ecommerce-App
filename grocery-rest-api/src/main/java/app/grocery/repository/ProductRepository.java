package app.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
         
	     @Query("SELECT p FROM Product p WHERE p.productName = :productName")
	     public List<Product> findByproductName(@Param("productName") String productName);
         
			/*
			 * @Query("SELECT p FROM Product p WHERE p.categoryId = :categoryId") public
			 * List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);
			 */
}
