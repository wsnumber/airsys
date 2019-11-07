package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ApplicationConfig;
import config.TestConfig;
import entity.Account;
import service.protptype.IAccountService;
import util.Pager;

/**
 * AccountServlet  模式
 * @author ll
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class AccountServIceTest {
	@Autowired
	private IAccountService actService;
	@Test
	public void testSearchAccount() {
		Pager<Account> pager = (Pager<Account>)actService.listPaged(1,4);
		for(Account act:pager.getData()) {
			System.out.println(act);
		}
		System.out.println(pager.getTotal());
	}
}
