package paintstore.service;

import java.util.List;

import paintstore.entity.Product;

public interface ProductService {
	void save(Product product);
	Product update(Product product,String id);
	List<Product> getListProduct();
	Product getProductById(String id);
	List<Product> findAllByCategory_Id(String idc);
}
