package paintstore.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.OrderDetail;
import paintstore.entity.OrderDetailPk;
import paintstore.repository.OrderDetailRepository;
import paintstore.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public List<OrderDetail> getListOrderDetail() {
		return orderDetailRepository.findAll();
	}
	
	@Override
	public OrderDetail save(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
		return orderDetailRepository.save(OrderDetail);
	}

	@Override
	public OrderDetail getOrderDetailById(OrderDetailPk ids) {
		// TODO Auto-generated method stub
		return orderDetailRepository.findByOrderIdAndProductId(ids.getOrder(), ids.getProduct());
	}

	@Override
	@Transactional
	public void deleteByProductIdAndCartId(String product, String order) {
		// TODO Auto-generated method stub
		orderDetailRepository.deleteByProductIdAndOrderId(product, order);
	}
	
	@Override
	public List<OrderDetail> getOrderDetailsByOrderId(String orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}
