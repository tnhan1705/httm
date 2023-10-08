package paintstore.service.user;

import java.util.List;

import paintstore.entity.Category;
import paintstore.entity.Product;

public interface UserHomeService {
	List<Product> getProductSlide();
	
	List<Category> getCategory();
}
