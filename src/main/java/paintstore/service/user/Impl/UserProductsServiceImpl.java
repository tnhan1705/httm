package paintstore.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public List<Product> getProductsByMSP(String MSP){
		return productsRepository.findByIdContaining(MSP);
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
	public Page<Product> getProductsOrderByNameAsc(Pageable pageable) {
		Page<Product> resultPage = productsRepository.findAllByOrderByNameAsc(pageable);
	    return resultPage;
	}

	@Override
	public Page<Product> getProductsOrderByNameDesc(Pageable pageable) {
		Page<Product> resultPage = productsRepository.findAllByOrderByNameDesc(pageable);
	    return resultPage;
	}

	@Override
	public Page<Product> getProductsOrderByPriceAsc(Pageable pageable) {
		Page<Product> resultPage = productsRepository.findAllByOrderByPriceAsc(pageable);
	    return resultPage;
	}

	@Override
	public Page<Product> getProductsOrderByPriceDesc(Pageable pageable) {
		Page<Product> resultPage = productsRepository.findAllByOrderByPriceDesc(pageable);
	    return resultPage;
	}
}
