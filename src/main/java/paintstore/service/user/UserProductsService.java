package paintstore.service.user;

import java.util.List;

import paintstore.entity.Product;

public interface UserProductsService {
	List<Product> getProducts();

	List<Product> getProductsByMDM(String MDM);
	
	List<Product> getProductsByMSP(String MSP);

	Product getProductById(String id);

	List<Product> searchProductByName(String name);

	List<Product> getProductsOrderByNameAsc();

	List<Product> getProductsOrderByNameDesc();

	List<Product> getProductsOrderByPriceAsc();

	List<Product> getProductsOrderByPriceDesc();
}
