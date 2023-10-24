package paintstore.repository;

import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import paintstore.entity.Account;
import paintstore.entity.Position;

public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("SELECT t.userName FROM Account t")
	List<String> findUsernames();

	Account findByUserName(String username);

	@TransactionScoped
	@Modifying
	@Query("UPDATE Account ac SET ac.position = :position WHERE ac.userName = :username")
	void updatePositionByUserName(@Param("username") String username, @Param("position") Position position);
}
