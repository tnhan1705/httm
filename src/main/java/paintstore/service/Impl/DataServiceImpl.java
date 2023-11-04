package paintstore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Data;
import paintstore.repository.DataRepository;
import paintstore.service.DataService;

@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataRepository dataRepository;
	
	@Override
	public void save(Data data) {
		dataRepository.save(data);
		
	}
}
