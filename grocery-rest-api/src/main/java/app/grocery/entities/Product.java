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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	

	@OneToOne(fetch = FetchType.EAGER,targetEntity = Category.class )
	@JoinColumn(name="categoryId")
	private Category category;
	
	@OneToOne(fetch = FetchType.EAGER,targetEntity = Seller.class)
    @JoinColumn(name="sellerId")
    private Seller seller;
	
	private String productName;
    private String productImage;
    private String productInfo;
    private double productPrice;
    
    public Product(Category category, String productName, String productImage, String productInfo, double productPrice,
			Seller seller) {
		super();
		this.category = category;
		this.productName = productName;
		this.productImage = productImage;
		this.productInfo = productInfo;
		this.productPrice = productPrice;
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", productName=" + productName
				+ ", productImage=" + productImage + ", productInfo=" + productInfo + ", productPrice=" + productPrice
				+ ", seller=" + seller + "]";
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public long getProductId() {
		return productId;
	}
	

}
