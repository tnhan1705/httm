package paintstore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Order;
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
	
}
