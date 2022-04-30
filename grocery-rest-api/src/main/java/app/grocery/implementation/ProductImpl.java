package app.grocery.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.grocery.entities.Category;
import app.grocery.entities.Product;
import app.grocery.entities.Seller;
import app.grocery.repository.CategoryRepository;
import app.grocery.repository.ProductRepository;
import app.grocery.repository.SellerRepository;
import app.grocery.service.ProductService;

@Service
public class ProductImpl implements ProductService{

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	SellerRepository sellerRepo;
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public Product getProduct(long productId) {
		
		
		return productRepo.findById(productId).get();
	}

	

	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return  productRepo.save(product);
		 
	}

	@Override
	public Product updateProduct(long productId,Product product) {
		Seller seller=sellerRepo.findById(product.getSeller().getSellerId()).get();
		Category category=categoryRepo.findById(product.getCategory().getCategoryId()).get();
		Product prod=productRepo.findById(productId).get();
		prod.setProductImage(product.getProductImage());
		prod.setProductName(product.getProductName());
		prod.setProductInfo(product.getProductInfo());
		prod.setCategory(category);
		prod.setSeller(seller);
		return productRepo.save(prod);
		 
	}

	@Override
	public String deleteProduct(long productId) {
		// TODO Auto-generated method stub
		productRepo.deleteById(productId);
		return "Product Deleted";
	}

	@Override
	public List<Product> findProductByCategory(long categoryId) {
		
		List<Product> productList=(List<Product>)productRepo.findAll();
		List<Product> productListByCategory=new ArrayList<Product>();
		for(Product product:productList)
		{
			if(product.getCategory().getCategoryId()==(categoryId))
			{
				productListByCategory.add(product);
			}
		}
		
		
		return productListByCategory;
	}

}
