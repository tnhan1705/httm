package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Account;
import paintstore.entity.Staffs;
import paintstore.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findOneByAccount(Account account);
	List<User> findAllByAccountStatus(boolean status);
}
