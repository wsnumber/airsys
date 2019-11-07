package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IUserDao;
import entity.User;
@Repository
public class UserDaoSpringImpl implements IUserDao{
	
	@Autowired
	private JdbcTemplate jtp;
	@Override
	public List<User> find(int offset, int pageSize) {
		
		return jtp.query("select * from user limit ?,?",
				new Object[] {offset,pageSize},
				new BeanPropertyRowMapper<User>(User.class));
	}
	
}
