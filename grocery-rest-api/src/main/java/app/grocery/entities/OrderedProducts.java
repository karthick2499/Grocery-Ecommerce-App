package app.grocery.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderedProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderedProductId;
	
	
	private String productName;
	private double productPrice;
	private int productQuantity;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Order.class)
	@JoinColumn(name="orderId")
	Order order;

	public OrderedProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderedProducts(String productName, double productPrice, int productQuantity, Order order) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.order = order;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getOrderedProductId() {
		return orderedProductId;
	}

	@Override
	public String toString() {
		return "OrderedProducts [orderedProductId=" + orderedProductId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", order=" + order + "]";
	}

	
	
	
	
	
}
