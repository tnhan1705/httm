package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import paintstore.entity.Category;
import paintstore.entity.Order;
import paintstore.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
		List<Order> findByUser(@Param("user") User user);
		
		List<Order> findAllByUser(User user);
		
		Order findOneByStatus(String status);
		
		@Query("SELECT COUNT(o.id) FROM Order o")
		Long countCartById();
		
		
		@Query("SELECT o FROM Order o WHERE o.user = :user AND o.id = :id")
		Order findByUserAndIdCart(@Param("user") User user, @Param("id") String orderId);
		
		@Query("SELECT o FROM Order o WHERE o.user.id = :userId")
	    public Order findByIdUser(@Param("userId") String userId);

		List<String> findOrderIdByUser(@Param("user") User user);
		Category findById(String id);
		
		Order findOneById(String id);
		
		List<Order> findAll();
}
