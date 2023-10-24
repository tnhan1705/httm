package paintstore.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Account;
import paintstore.entity.User;
import paintstore.repository.UserRepository;
import paintstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findOneByAccount(Account account) {
		return userRepository.findOneByAccount(account);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
