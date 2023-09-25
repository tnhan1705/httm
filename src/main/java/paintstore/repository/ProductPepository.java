package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Product;

public interface ProductPepository extends JpaRepository<Product, String> {
	List<Product> findAllByCategory_Id(String idc);
	List<Product> findAllByStatus(boolean b);
}
