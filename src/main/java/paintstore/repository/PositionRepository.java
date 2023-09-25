package paintstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Position;

public interface PositionRepository extends JpaRepository<Position, String> {
	Position findOneByName(String name);
}
