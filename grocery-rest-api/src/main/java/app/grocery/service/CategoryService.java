package app.grocery.service;

import java.util.List;

import app.grocery.entities.Category;
import app.grocery.entities.Product;

public interface CategoryService {
	public List<Category> getcategories();
	public Category getCategory(long categoryId);
	public Category addCategory(Category Category);
	public Category updateCategory(long productId,Category category);

}
