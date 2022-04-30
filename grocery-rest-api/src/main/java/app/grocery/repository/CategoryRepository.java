package app.grocery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.grocery.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
