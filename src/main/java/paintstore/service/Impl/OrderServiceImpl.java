package paintstore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Order;
import paintstore.entity.User;
import paintstore.repository.OrderRepository;
import paintstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getListOrder() {
		return orderRepository.findAll();
	}


	@Override
	public Order findOneById(Long ido) {
		return orderRepository.findOne(ido);
	}

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}


	@Override
	public List<Order> getOrderByUser(User user) {
		// TODO Auto-generated method stub
		return orderRepository.findAllByUser(user);
	}


	@Override
	public Order findOrderByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Order findOrderByStatus(String status) {
		// TODO Auto-generated method stub
		return orderRepository.findOneByStatus(status);
	}


	@Override
	public Order getOrderByUserAndIdOrder(User user, String order) {
		// TODO Auto-generated method stub
		return orderRepository.findByUserAndIdCart(user, order);
	}	
}
