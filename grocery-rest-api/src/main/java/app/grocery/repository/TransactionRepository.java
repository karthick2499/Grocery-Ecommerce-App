package app.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Transaction;
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
	
	
	@Query(value="SELECT * FROM Transaction  WHERE customer_id = ?1",nativeQuery = true)
	public List<Transaction> findTransactionBycustomerid(long customerId);

}
