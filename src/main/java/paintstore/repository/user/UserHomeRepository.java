package paintstore.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Product;

public interface UserHomeRepository extends JpaRepository<Product, String> {

}
