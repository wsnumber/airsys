package serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ApplicationConfig;
import entity.Account;
import entity.User;
import service.protptype.IUserService;
import util.Pager;

/**
 * 用户业务单元测试
 * @author ll
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ApplicationConfig.class})
public class UserServiceTest {
	@Autowired
	private IUserService userService;
	@Test
	public void findPaged() {
		Pager<User> pager = (Pager<User>)userService.listUsers(1, 10);
		for(User user:pager.getData()) {
			System.out.println(user);
		}
	}
}
