package paintstore.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Category;
import paintstore.entity.Product;
import paintstore.repository.user.UserHomeCategoryRepositoy;
import paintstore.repository.user.UserHomeRepository;
import paintstore.service.user.UserHomeService;

@Service
public class UserHomeServiceImpl implements UserHomeService {

	@Autowired
	UserHomeRepository userHomeRepository;
	
	@Autowired
	UserHomeCategoryRepositoy userHomeCategoryRepositoy;
	
	@Override
	public List<Product> getProductSlide() {
		return userHomeRepository.findAll();
	}

	@Override
	public List<Category> getCategory() {
		return userHomeCategoryRepositoy.findAll();
	}

}
