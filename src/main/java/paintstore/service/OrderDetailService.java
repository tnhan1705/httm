package paintstore.service;

import java.util.List;

import paintstore.entity.OrderDetail;
import paintstore.entity.OrderDetailPk;

public interface OrderDetailService {
	OrderDetail save(OrderDetail OrderDetail);
	
	List<OrderDetail> getListOrderDetail();
	
	List<OrderDetail> getOrderDetailsByOrderId(String orderId);
	
	OrderDetail getOrderDetailById(OrderDetailPk id);
	
	void deleteByProductIdAndCartId(String product, String order);
}
