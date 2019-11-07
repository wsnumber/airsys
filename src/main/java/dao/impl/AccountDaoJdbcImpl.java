package dao.impl;

import java.sql.Connection;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAcoountDao;
import entity.Account;

import util.Pager;

@Repository("accountDaoJdbcImpl")
public class AccountDaoJdbcImpl implements IAcoountDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void modify(Account from, Connection con) {
		
	}
	@Override
	public Account find(int id) {
		System.out.println(id);
		jdbcTemplate.query("select * from account where id=?", 
				new Object[]{id},  //  参数
				new BeanPropertyRowMapper<>(Account.class));
		return null;
	}

	@Override
	public void modify(Account act) {
		
	}

	@Override
	public List<Account> findAll() {
		return null;
	}

	@Override
	public List<Account> find(int offset, int pageSize) {
		return jdbcTemplate.query(
				"select * from account limit ?,?", 
				new Object[]{offset,pageSize}, 
				new BeanPropertyRowMapper<Account>(Account.class));
	}
	@Override
	public Pager<Account> findPaged(int offset, int pageSize) {
		return null;
	}

	@Override
	public int totalItems() {
		return 0;
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("delete from account where id=?",new Object[]{id});
	}
	@Override
	public void saveOrUpdata(Account act) {
		if(act.getId()==0) {
			jdbcTemplate.update("insert into account (name,balance) values (?,?)",
			new Object[] {act.getName(),act.getBalance()}
			);
		}else {
			jdbcTemplate.update(
					"update account set name=?,balance=? where id=?",
					new Object[] {act.getName(),act.getBalance(),act.getId()}
					);
		}
	}
}
