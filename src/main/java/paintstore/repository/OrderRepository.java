package paintstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
