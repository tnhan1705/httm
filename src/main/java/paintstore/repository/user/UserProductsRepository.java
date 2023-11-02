package paintstore.repository.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Product;

public interface UserProductsRepository extends JpaRepository<Product, String> {

	List<Product> findAllByCategory_Id(String category);

	List<Product> findByNameContaining(String name);
	
	List<Product> findByIdContaining(String id);

	Page<Product> findAllByOrderByNameAsc(Pageable pageable);

	Page<Product> findAllByOrderByNameDesc(Pageable pageable);

	Page<Product> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Product> findAllByOrderByPriceDesc(Pageable pageable);
}
