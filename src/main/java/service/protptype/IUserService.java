package service.protptype;

import java.util.List;

import entity.User;
import util.MiniPager;

public interface IUserService {
	@MiniPager(tableName="user")
	List<User> listUsers(int pageNo,int pageSize);
}
