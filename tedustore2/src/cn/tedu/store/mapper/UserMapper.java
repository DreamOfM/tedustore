package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.User;

public interface UserMapper {
	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	Integer getCount();
	User getUserByEmail(String email);
	/**
	 * 查询 用户名对应了几条记录
	 * @param username
	 * @return
	 */
	Integer getCountByUsername(String username);
	User FindUser(User user);
	User getUserByPhone(String phone);
	void insert(User user);
	

}
