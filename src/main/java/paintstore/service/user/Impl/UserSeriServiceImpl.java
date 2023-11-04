package paintstore.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Seri;
import paintstore.repository.user.UserSeriRepository;
import paintstore.service.user.UserSeriService;

@Service
public class UserSeriServiceImpl implements UserSeriService {

	@Autowired
	UserSeriRepository userSeriRepository;
	
	@Override
	public List<Seri> getAllSeriByProduct(String id) {
		return userSeriRepository.findAllByProduct_Id(id);
	}

	@Override
	public List<Seri> getAllSeriByProductAndColor(String id, String color) {
		// TODO Auto-generated method stub
		return userSeriRepository.findAllByProduct_IdAndColor(id, color);
	}
	
	@Override
	public List<Seri> getAllSeriByColor(String color){
		return userSeriRepository.findAllByColor(color);
	}

	@Override
	public int countSeriByProductAndColor(String id, String color) {
		// TODO Auto-generated method stub
		return userSeriRepository.countByProductIdAndColor(id, color);
	}

	@Override
	public List<Seri> findAllByProduct_IdAndStatus(String id, boolean status) {
		
		return userSeriRepository.findAllByProduct_IdAndStatus(id, status);
	}
}
