package service.protptype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

/**
 * Account业务接口
 * @author ll
 *
 */
public interface IAccountService {
	void transfer(Account from,Account to,double money);
	
	Account searchAccount(int id);
	@MiniPager(tableName="account")
	List<Account> listAccounts(int pageNo,int pageSize);
	@MiniPager(tableName="account")
	List<Account> listPaged(int pageNo,int pageSize);
}
