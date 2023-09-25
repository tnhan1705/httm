package paintstore.service;

import java.util.List;

import paintstore.entity.Account;

public interface AccountService {
	public Account findByUsername(String username);
	
	public void save(Account account);
	
	public void saveStaff(Account account);
	
	public void delete(Account account); 
	
	public List<String> gellListUnameAccount();
	
	
}
