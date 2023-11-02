package paintstore.service.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import paintstore.entity.Product;

public interface UserProductsService {
	List<Product> getProducts();

	List<Product> getProductsByMDM(String MDM);
	
	List<Product> getProductsByMSP(String MSP);

	Product getProductById(String id);

	List<Product> searchProductByName(String name);

	Page<Product> getProductsOrderByPriceAsc(Pageable pageable);

	Page<Product> getProductsOrderByNameDesc(Pageable pageable);

	Page<Product> getProductsOrderByNameAsc(Pageable pageable);

	Page<Product> getProductsOrderByPriceDesc(Pageable pageable);
}
