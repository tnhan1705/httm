package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Seri;

public interface SeriRepository extends JpaRepository<Seri, String> {
	Seri findOneByProduct_IdAndColorAndStatus(String id,String color,boolean status);
	List<Seri>  findAllByReceipt_Id(String idr);
	List<Seri>  findAllByReceipt_IdAndProduct_Id(String idr,String idp);
	List<Seri>  findAllByProduct_IdAndStatus(String idp,boolean status);
	List<Seri>  findAllByProduct_Id(String idp);
	List<Seri>  findAllByProduct_IdOrderByReceipt_Id(String idp);
	
}
