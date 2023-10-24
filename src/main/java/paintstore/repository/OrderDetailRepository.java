package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import paintstore.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
	List<OrderDetail> findByOrderId(String id);

	void deleteByProductIdAndOrderId(String product, String order);

	@Modifying
	@Query("UPDATE OrderDetail od SET od.quantity = :newQuantity WHERE od.product.id = :productId AND od.order.id = :orderId")
	void updateQuantityByProductIdAndorderId(@Param("productId") String productId, @Param("orderId") String orderId,
			@Param("newQuantity") int newQuantity);
	/* boolean isProductExist(String orderId, String productId); */

	// THÊM
	OrderDetail findByOrderIdAndProductId(String orderId, String productId);
}
