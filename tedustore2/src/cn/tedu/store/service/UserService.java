package cn.tedu.store.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.ex.*;
//import cn.tedu.store.controller.UserNotFoundException;
import cn.tedu.store.mapper.UserMapper;

@Service
public class UserService implements IUserService {
    @Autowired   
	 private UserMapper userMapper;

       
	@Override
	public boolean checkLoginUsername(String username) {
	    
		
		Integer num=userMapper.getCountByUsername(username);
		return num==1;
	}


	@Override
	public User login(String username,String password) {
	
		//检查数据的有效性
				if(username==null||username.equals("")){
					throw new UserNotFoundException("用户名不能为空");
				}
				if(password==null||password.equals("")){
					throw new PasswordNotMatchException("密码不能为空");
				}
				 //业务判断处理
				User user=userMapper.getUserByUsername(username);
				if(user==null) {
					throw new UserNotFoundException("用户不存在");
					
				}else {
					if(user.getPassword().equals(password)) {
						return user;
					}else {
						throw new PasswordNotMatchException("密码错误");
					}
				}
		//return 	userMapper.FindUser(username,password);
	
	}
/**
 * 检查用户名是否可用
 */

	@Override
	public boolean checkUsername(String username) {
		if(username==null||username.equals("")) {
			return false;
		}
		Integer num=userMapper.getCountByUsername(username);
		return num==0;
	}


	@Override
	public boolean checkEmail(String email) {
		User user=userMapper.getUserByEmail(email);
		if(user==null)
	   	return true;
		else {
			return false;
		}
	}


	@Override
	public boolean checkPhone(String phone) {
	User user=	userMapper.getUserByPhone(phone);
		if(user==null)
		   	return true;
			else {
				return false;
			}
	}


	@Override
	public void insert(User user) {
		System.out.println(user.getUsername());
		userMapper.insert(user);
		
	}






}
