package cn.tedu.store.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Controller  //url=/tedustore/user/checkLoginUsername.do

@RequestMapping("/user")
public class UserController {     //成员名尽量不要用is开头，方法名可以
	
	@Autowired   //资源注入
	 IUserService userService;
	
	
	@RequestMapping("/checkLoginUsername.do") //根据url匹配
	
	
	@ResponseBody
	public String checkLoginUsername(String username) { //需要什么变量，直接写可从表单获取
		//String username=		req.getParameter("username");
		boolean isExist=userService.checkLoginUsername(username);
		
		if(isExist) {
			return "yes";
		}else {
			return "no";
		}
		
	}
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	/**
	 * 
	 * @param user
	 * @param map
	 * @return    @ResponseBody  注解会将把返回的字符串添加到当作响应结果中
	 * 	 */
	//处理表单的提交，即开始检查用户输入的用户名和密码是否正确
	//@RequestMapping("/login.do") //text/plain;charset=ISO-8859-1
	@RequestMapping(value="/login.do",produces="text/plain;charset=utf-8")
	@ResponseBody     //把返回的字符穿当作相应体
 public String  login(User user,HttpSession session) {
	
		System.out.println(user);
		String username=user.getUsername();
		String password=user.getPassword();
		try {
			User user1 = userService.login(username,password);
			session.setAttribute("user", user1);
			return "ok";
		} catch (UserNotFoundException | PasswordNotMatchException e) {
			return e.getMessage();
	//		e.printStackTrace();
		}
		/*if(userService.login(username, password)!=null)
		{
		 // map.put("loginName", user2.getUsername());
		  System.out.println("查询到");
			return "ok";
		}
		else 
		{System.out.println("未查询到");
		return "no";}*/
			//return "ok";
		/*if(userService.FindUser(user)!=null)
		{
			
		  User user2=userService.FindUser(user);
		  System.out.println(user2);
		 // map.put("loginName", user2.getUsername());
		  System.out.println("查询到");
			return "ok";
		}
		else 
			{System.out.println("未查询到");
			return "no";}*/
	}
	/**
	 * 注解@RequestBody说明：
	 * 1.将方法返回结果，直接放入到响应体中
	 * 2.返回值类型如果是string，原封不动直接放入响应体中
	 * 3.返回值类型如果是其他类型，
	 * （1）classpath中有jackson-*.jar将返回值，转换为json格式的字符串。
	 * （	 * classpath中有相应的MassageConverter的实现类jar包）
	 * （2）classpath中没有相关的jar包，失败报错
	 
	 */
	
	@RequestMapping("showRegister.do")
	
	public String showRegister() {
		
		return "register";
	}
	
	@RequestMapping("checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		//调用业务代码，判断用户名是否可用/有效
		boolean isValid = userService.checkUsername(username);
		if(isValid) {
		return new ResponseResult<Void>(1,"用户名可以使用");
		}
		else {
			return new ResponseResult<Void>(0,"用户名已经被占用");
		}
	}
	@RequestMapping("checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		//调用业务代码，判断用户名是否可用/有效
		boolean isValid = userService.checkEmail(email);
		if(isValid) {
		return new ResponseResult<Void>(1,"email可以使用");
		}
		else {
			return new ResponseResult<Void>(0,"email已被注册");
		}
	}
	
	
	@RequestMapping("checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		//调用业务代码，判断用户名是否可用/有效
		boolean isValid = userService.checkPhone(phone);
		if(isValid) {
		return new ResponseResult<Void>(1,"该号码可以使用");
		}
		else {
			return new ResponseResult<Void>(0,"该号码已被注册");
		}
	}
	@RequestMapping("register.do")
	@ResponseBody
	public ResponseResult<Void> register(User user,String uname,String upwd) {
	
		//调用业务代码，判断用户名是否可用/有效
		user.setUsername(uname);
		user.setPassword(upwd);
		userService.insert(user);
		return new ResponseResult<Void>(1,"注册成功");
		/*if(isValid) {
		return new ResponseResult<Void>(1,"该号码可以使用");
		}
		else {
			return new ResponseResult<Void>(0,"该号码已被注册");
		}*/
	}
	
	@ExceptionHandler
	public ModelAndView doException(Exception e) throws Exception {
		System.out.println(e);
		//在当前方法中，处理能够处理的异常，无法处理的或希望框架统一处理的异常，继续上抛
		
		Map map=new HashMap<>();
		map.put("exception",e);//手工向叶脉年传异常对象
//		model.addAttribute("exception",e);  
		return new ModelAndView("error");
		//return"jsp/error";
	
		
	}
	
	

}
