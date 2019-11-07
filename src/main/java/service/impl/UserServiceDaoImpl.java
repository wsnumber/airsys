package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IUserDao;
import entity.User;
import service.protptype.IUserService;

@Service
public class UserServiceDaoImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Override
	public List<User> listUsers(int pageNo, int pageSize) {
		
		return userDao.find((pageNo-1)*pageSize, pageSize);
	}

}
