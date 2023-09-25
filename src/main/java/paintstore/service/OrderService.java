package paintstore.service;

import java.util.List;

import paintstore.entity.Order;

public interface OrderService {
	List<Order> getListOrder();
	Order findOneById(Long ido);
	void save(Order order);
	
}
