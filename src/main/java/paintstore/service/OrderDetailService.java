package paintstore.service;

import paintstore.entity.OrderDetail;
import paintstore.entity.OrderDetailPk;

public interface OrderDetailService {
	OrderDetail save(OrderDetail OrderDetail);
	
	OrderDetail getOrderDetailById(OrderDetailPk id);
	
	void deleteByProductIdAndCartId(String product, String order);
}
