package paintstore.service;

import paintstore.entity.Account;
import paintstore.entity.User;

public interface UserService {
	User findOneByAccount(Account account);
	
	void saveUser(User user);
	
	void deleteUser(String userId);
	
	void updateUser(User user);
	
	User getUserById(String id);
}
