package paintstore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Seri;
import paintstore.repository.SeriRepository;
import paintstore.service.SeriService;
@Service
public class SeriServiceImpl implements SeriService {

	@Autowired
	private SeriRepository seriRepository;
	@Override
	public void save(Seri seri) {
		seriRepository.save(seri);
		
	}
	@Override
	public Seri findOneByProduct_IdAndColorAndStatus(String id, String color,boolean status) {
		return seriRepository.findOneByProduct_IdAndColorAndStatus(id, color,status);
	}
	@Override
	public List<Seri> findAllByReceipt_Id(String idr) {
		// TODO Auto-generated method stub
		return seriRepository.findAllByReceipt_Id(idr);
	}
	@Override
	public List<Seri> findAllByReceipt_IdAndProduct_Id(String idr, String idp) {
		// TODO Auto-generated method stub
		return seriRepository.findAllByReceipt_IdAndProduct_Id(idr, idp);
	}
	@Override
	public List<Seri> findAllByProduct_IdAndStatus(String idp, boolean status) {
		
		return seriRepository.findAllByProduct_IdAndStatus(idp, status);
	}
	
	

}
