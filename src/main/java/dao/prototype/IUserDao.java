package dao.prototype;

import java.util.List;

import entity.User;

public interface IUserDao {
	List<User> find(int offset,int pageSize);
}
