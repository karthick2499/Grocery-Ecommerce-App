package app.grocery.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER )
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
	
	@ManyToOne(targetEntity = Order.class,fetch = FetchType.EAGER )
	@JoinColumn(name="orderId")
	private Order order;
	
	
	private String transactionMode;
	
	private double transactionAmount;
	
	
	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	private Date transactionDate;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Transaction(Customer customer, Order order, String transactionMode, double transactionAmount,
			Date transactionDate) {
		super();
		this.customer = customer;
		this.order = order;
		this.transactionMode = transactionMode;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getTransactionId() {
		return transactionId;
	}

	
	

}
