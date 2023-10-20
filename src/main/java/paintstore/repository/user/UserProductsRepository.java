package paintstore.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Product;

public interface UserProductsRepository extends JpaRepository<Product, String> {

	List<Product> findAllByCategory_Id(String category);

	List<Product> findByNameContaining(String name);
	
	List<Product> findByIdContaining(String id);

	List<Product> findAllByOrderByNameAsc();

	List<Product> findAllByOrderByNameDesc();

	List<Product> findAllByOrderByPriceAsc();

	List<Product> findAllByOrderByPriceDesc();
}
