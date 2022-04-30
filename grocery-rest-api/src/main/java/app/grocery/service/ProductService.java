package app.grocery.service;

import java.util.List;

import app.grocery.entities.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public Product getProduct(long productId);
	public Product addProduct(Product product);
	public Product updateProduct(long productId,Product product);
	public String deleteProduct(long productId);
	public List<Product> findProductByCategory(long categoryId);

}
