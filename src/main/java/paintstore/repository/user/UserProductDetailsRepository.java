package paintstore.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import paintstore.entity.Product;


public interface UserProductDetailsRepository extends JpaRepository<Product, String> {
	Product findById(String id);
}
