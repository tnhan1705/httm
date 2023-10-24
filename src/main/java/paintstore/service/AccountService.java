package paintstore.service;

import java.util.List;

import paintstore.entity.Account;
import paintstore.entity.Position;

public interface AccountService {
	public Account findByUsername(String username);
	
	public void save(Account account);
	
	public void saveStaff(Account account);
	
	public void delete(Account account); 
	
	public List<String> gellListUnameAccount();
	
	//THÊM
			//GIO HANG
			Account getAccountById(String id);
					
			public void updatePositionByUser(String username, Position position);
			
			public void saveUser(Account account);
}
