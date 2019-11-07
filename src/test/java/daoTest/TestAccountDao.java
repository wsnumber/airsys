package daoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ApplicationConfig;
import dao.prototype.IAcoountDao;
import entity.Account;
import service.protptype.IAccountService;

/**
 * Spring 单元测试
 * @author ll
 *	
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class})
public class TestAccountDao {
	@Autowired
	private IAcoountDao actDao;

	@Test
	public void testfindById() {
		Account act=actDao.find(2);
		System.out.println(act);
	}
	
}
