package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
	List<Category> findByStatus(boolean b);
}
