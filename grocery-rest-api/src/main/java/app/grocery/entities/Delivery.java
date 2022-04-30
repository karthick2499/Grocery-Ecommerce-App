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
import javax.persistence.ManyToOne;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deliveryId;
	
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Customer.class,cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;

	private Date deliveryDate;
	private String deliveryStatus;
	private String delivaryLocation;
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delivery(Customer customer, Date deliveryDate, String deliveryStatus, String delivaryLocation) {
		super();
		this.customer = customer;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.delivaryLocation = delivaryLocation;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDelivaryLocation() {
		return delivaryLocation;
	}
	public void setDelivaryLocation(String delivaryLocation) {
		this.delivaryLocation = delivaryLocation;
	}
	public long getDeliveryId() {
		return deliveryId;
	}
	
	
	
	
}
