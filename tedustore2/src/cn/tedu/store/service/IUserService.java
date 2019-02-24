package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {

	boolean checkLoginUsername(String username);

	User login(String  username,String password);

	boolean checkUsername(String username);

	boolean checkEmail(String email);

	boolean checkPhone(String phone);



	void insert(User user);

}
