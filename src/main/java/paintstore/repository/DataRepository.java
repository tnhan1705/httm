package paintstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Data;

public interface DataRepository extends JpaRepository<Data, String>{

}
