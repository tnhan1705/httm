package paintstore.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import paintstore.entity.Seri;

public interface UserSeriRepository extends JpaRepository<Seri, String> {
	List<Seri> findAllByProduct_Id(String id);
	List<Seri> findAllByProduct_IdAndColor(String productId, String color);
	
	@Query("SELECT COUNT(s) FROM Seri s WHERE s.product.id = :productId AND s.color = :color")
    int countByProductIdAndColor(@Param("productId") String productId, @Param("color") String color);
}
