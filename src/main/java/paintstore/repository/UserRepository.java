package paintstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Account;
import paintstore.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findOneByAccount(Account account);
}
