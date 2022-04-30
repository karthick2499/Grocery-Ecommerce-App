package app.grocery.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



@Entity
@Table(name="customer_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
	private String  orderDate;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Customer customer, String orderDate) {
		super();
		this.customer = customer;
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderdate(String orderDate) {
		this.orderDate = orderDate;
	}
	public long getOrderId() {
		return orderId;
	}
	
}
