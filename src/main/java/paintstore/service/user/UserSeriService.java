package paintstore.service.user;

import java.util.List;

import paintstore.entity.Seri;

public interface UserSeriService {
	List<Seri> getAllSeriByProduct(String id);
	List<Seri> getAllSeriByProductAndColor(String id, String color);
	List<Seri> getAllSeriByColor(String color);
	List<Seri> findAllByProduct_IdAndStatus(String id,boolean status);
	int countSeriByProductAndColor(String id, String color);
}
