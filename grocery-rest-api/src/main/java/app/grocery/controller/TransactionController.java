package app.grocery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.grocery.entities.Customer;
import app.grocery.entities.Order;
import app.grocery.entities.Transaction;
import app.grocery.repository.CustomerRepository;
import app.grocery.repository.OrderRepository;
import app.grocery.repository.TransactionRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/grocery/v1")
public class TransactionController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	TransactionRepository transactionRepo;

	@PostMapping("/addtransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction)
	{
		Order  order=orderRepo.findById(transaction.getOrder().getOrderId()).get();
		Customer customer=customerRepo.findById(transaction.getCustomer().getCustomerId()).get();
		if(customer!=null && order!=null)
		{
			transaction.setOrder(order);
			transaction.setCustomer(customer);
			return transactionRepo.save(transaction);
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("/getalltransactions")
	public List<Transaction> getAllTransactions()
	{
		return (List<Transaction>) transactionRepo.findAll();
				
		
	}
	
	@GetMapping("/getalltransactionsbycustomerid/{customerId}")
	public List<Transaction> getAllTransactionsBycustomerId(@PathVariable("customerId") long customerId)
	{
		
		
			return (List<Transaction>)  transactionRepo.findTransactionBycustomerid(customerId);
		
					
		
	}
	
}
