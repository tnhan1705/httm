package paintstore.service;

import java.util.List;

import paintstore.entity.Order;
import paintstore.entity.User;

public interface OrderService {
	List<Order> getListOrder();
	List<Order> getOrderByUser(User user);
	Order findOneById(Long ido);
	void save(Order order);
	Order findOrderByUser(User user);
	Order findOrderByStatus(String status);
	
	Order getOrderByUserAndIdOrder(User user, String order);
}
