package paintstore.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Category;
import paintstore.entity.Product;

public interface UserHomeCategoryRepositoy extends JpaRepository<Category, String> {

}
