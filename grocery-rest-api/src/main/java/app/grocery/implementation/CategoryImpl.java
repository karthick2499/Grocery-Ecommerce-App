package app.grocery.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.grocery.entities.Category;
import app.grocery.repository.CategoryRepository;
import app.grocery.service.CategoryService;

@Service
public class CategoryImpl  implements CategoryService
{
@Autowired	
CategoryRepository categoryRepo;
	
	@Override
	public List<Category> getcategories() {
		
		return (List<Category>) categoryRepo.findAll();
	}

	@Override
	public Category getCategory(long categoryId) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(categoryId).get();
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(long categopryId, Category category) {
		Optional<Category> cat=categoryRepo.findById(categopryId);
		if(cat.isPresent())
		{   Category c=cat.get();
			c.setCategoryName(category.getCategoryName());
			c.setCategoryType(category.getCategoryType());
			return categoryRepo.save(c);
		}
		else
		{
		return null;
	}
	}
}
