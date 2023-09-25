package paintstore.service;

import paintstore.entity.Position;

public interface PositionService {
	Position findOneByName(String name);
	
	void save(Position position);
}
