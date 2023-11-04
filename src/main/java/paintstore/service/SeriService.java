package paintstore.service;

import java.util.List;

import paintstore.entity.Seri;

public interface SeriService {
	void save(Seri seri);
	Seri findOneByProduct_IdAndColorAndStatus(String id,String color,boolean status);
	List<Seri>  findAllByReceipt_Id(String idr);
	List<Seri>  findAllByReceipt_IdAndProduct_Id(String idr,String idp);
	List<Seri>  findAllByProduct_IdAndStatus(String idp,boolean status);
}
