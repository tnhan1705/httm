package paintstore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Position;
import paintstore.repository.PositionRepository;
import paintstore.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService{
	
	@Autowired PositionRepository positionRepository;
	
	@Override
	public Position findOneByName(String name) {
		return positionRepository.findOneByName(name) ;
	}

	@Override
	public void save(Position position) {
		positionRepository.save(position);
		
	}

}
