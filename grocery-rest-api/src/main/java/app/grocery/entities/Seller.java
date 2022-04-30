package app.grocery.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sellerId;
		
	private String sellerName;
	private long sellerContact;
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seller(String sellerName, long sellerContact) {
		super();
		this.sellerName = sellerName;
		this.sellerContact = sellerContact;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public long getSellerContact() {
		return sellerContact;
	}
	public void setSellerContact(long sellerContact) {
		this.sellerContact = sellerContact;
	}
	public long getSellerId() {
		return sellerId;
	}
	
	
	
	
}
