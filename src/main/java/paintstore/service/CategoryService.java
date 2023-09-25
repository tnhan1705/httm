package paintstore.service;

import java.util.List;

import paintstore.entity.Category;

public interface CategoryService {
	void addCategory(Category category);
	List<Category> getListCategory();
	List<Category> getListCategoryByStatus(boolean b);
	Category findOneById (String id);
	
	Category update (Category category,String id);
	
	void deleteCategoty(String id);
}
