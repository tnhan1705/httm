package paintstore.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Product;
import paintstore.repository.user.UserProductDetailsRepository;
import paintstore.service.user.UserProductDetailsService;

@Service
public class UserProductDetailsServiceImpl implements UserProductDetailsService {
	
	@Autowired
	UserProductDetailsRepository userProductDetailsRepository;

	@Override
	public Product getProductDetails(String id) {
		return userProductDetailsRepository.findById(id);
	}

}
