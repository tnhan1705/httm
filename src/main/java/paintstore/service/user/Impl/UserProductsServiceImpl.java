package paintstore.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Product;
import paintstore.repository.user.UserProductsRepository;
import paintstore.service.user.UserProductsService;

@Service
public class UserProductsServiceImpl implements UserProductsService {

	@Autowired
	UserProductsRepository productsRepository;
	
	@Override
	public List<Product> getProducts() {
		return productsRepository.findAll();
	}

	@Override
	public List<Product> getProductsByMDM(String MDM) {
		return productsRepository.findAllByCategory_Id(MDM);
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return productsRepository.findOne(id);
	}

	@Override
	public List<Product> searchProductByName(String name) {
		
		return productsRepository.findByNameContaining(name);
	}

	@Override
	public List<Product> getProductsOrderByNameAsc() {
		// TODO Auto-generated method stub
		return productsRepository.findAllByOrderByNameAsc();
	}

	@Override
	public List<Product> getProductsOrderByNameDesc() {
		// TODO Auto-generated method stub
		return productsRepository.findAllByOrderByNameDesc();
	}

	@Override
	public List<Product> getProductsOrderByPriceAsc() {
		// TODO Auto-generated method stub
		return productsRepository.findAllByOrderByPriceAsc();
	}

	@Override
	public List<Product> getProductsOrderByPriceDesc() {
		// TODO Auto-generated method stub
		return productsRepository.findAllByOrderByPriceDesc();
	}
}
