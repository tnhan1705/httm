package paintstore.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import paintstore.dto.MyUser;
import paintstore.entity.Account;
import paintstore.repository.AccountRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private AccountRepository accountRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account user = accountRepository.findByUserName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User name not fond");
		}
		
		if (user.getStatus() == false) {
			throw new DisabledException("Tài khoảng bị khóa");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getPosition().getName()));
		
		MyUser myUser = new MyUser(user.getUserName(), user.getPassWord(), true, true, true, true, authorities);
		
		if (user.getPosition().getName().equals("ADMIN") || user.getPosition().getName().equals("EMPLOYEE")) {
			myUser.setFullName(user.getStaff().getSurname() +" "+ user.getStaff().getName());
			myUser.setImage(user.getStaff().getImage());
			myUser.setPosition(user.getPosition().getName());
		}
		else {
			myUser.setFullName(user.getUser().getSurname() +" "+ user.getUser().getName());
			myUser.setImage(user.getUser().getImage());
			myUser.setPosition(user.getPosition().getName());
		}
		return myUser;
	}
	

}
