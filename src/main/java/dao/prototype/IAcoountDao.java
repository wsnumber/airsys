package dao.prototype;

import java.sql.Connection;
import java.util.List;

import entity.Account;
import util.Pager;

/*
 * accountService实现：是直接写的JDBC代码来实现的
 * 
 * accountDao来实现该操作：
 * 		IAccountDao:
 * 			void modify(xxx);
 * 		AccountServiceDaoImpl{
 * 			private IAccountDao actDao;
 * 			void transfer(xxx){
 * 			
 * 			}
 * 		}
 */
public interface IAcoountDao {
	//  连接参数化
	void modify(Account from,Connection con);   //  修改账户的方法
	
	Account find(int id);
	
	void modify(Account act);
	
	List<Account> findAll();
	
	//  你这么返回的是数据，但是我们要做的分页光数据是不够的
	List<Account> find(int offset,int pageSize);    // 0, Integer.MaxValue
	
	Pager<Account> findPaged(int offset,int pageSize);
	
	int totalItems();  //  获取总条目数
	
	void delete(int id);
	
	void saveOrUpdata(Account act);
}
