package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAcoountDao;
import entity.Account;
import service.protptype.IAccountService;
import util.Pager;

/**
 * Account业务实现类
 * @author ll
 *
 */
@Service("accountSercviceDaoImpl")
public class AccountSercviceDaoImpl implements IAccountService {
	@Autowired  //  自动封装
	private IAcoountDao actDao;
	@Override   // 	涉及到事务   Spring 声明式的Transaction处理（AOP动态代理模式的应用）
 	public void transfer(Account from, Account to, double money) {
		
	}

	@Override
	public Account searchAccount(int id) {
	
		return actDao.find(id);   
		//   
	}

	@Override
	public List<Account> listAccounts(int pageNo, int pageSize) {
		
		return null;
	}

	@Override
	public List<Account> listPaged(int pageNo, int pageSize) {
		System.out.println(actDao.find((pageNo-1)*pageSize, pageSize));
		return actDao.find((pageNo-1)*pageSize, pageSize);
	}

}
