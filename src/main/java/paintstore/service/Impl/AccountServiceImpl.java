package paintstore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import paintstore.entity.Account;
import paintstore.repository.AccountRepository;
import paintstore.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRpst;

	@Override
	public Account findByUsername(String username) {

		return accountRpst.findByUserName(username);
	}

	@Override
	public void save(Account account) {

		account.setStatus(true);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		account.setPassWord(bCryptPasswordEncoder.encode(account.getPassWord()));
		accountRpst.save(account);

	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> gellListUnameAccount() {
		return accountRpst.findUsernames();
	}

	@Override
	public void saveStaff(Account account) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		account.setPassWord(bCryptPasswordEncoder.encode(account.getPassWord()));
		account.setStatus(true);
		
		accountRpst.save(account);

	}

}
