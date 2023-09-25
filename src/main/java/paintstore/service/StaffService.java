package paintstore.service;

import java.util.List;

import paintstore.entity.Account;
import paintstore.entity.Staffs;


public interface StaffService {
	
	Staffs findOneByAccount(Account account);
	
	void save(Staffs staffs);
	
	void delete(String  idStaffs);
	List<Staffs> findAll();
	List<Staffs> findAllByStatus(boolean status);
}
