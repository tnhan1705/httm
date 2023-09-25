package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import paintstore.entity.Account;



public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("SELECT t.userName FROM Account t")
	List<String> findUsernames();
	
	Account findByUserName (String username);
	
	
}
