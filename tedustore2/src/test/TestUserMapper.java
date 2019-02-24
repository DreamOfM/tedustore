package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;

public class TestUserMapper {
	@Test
	public void testGetUserByUsername() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml","spring-service.xml");
		System.out.println(ac);
		//2.取得Usermapper接口的实现类
		UserMapper mapper = ac.getBean("userMapper",UserMapper.class);
		System.out.println(mapper);
		
		
		//3.执行数据查询
		User user = mapper.getUserByUsername("test01");		
		System.out.println(user);
		
		//TODO 根据邮箱查询用户信息？
		System.out.println(mapper.getUserByEmail("1137148011@qq.com"));
		//TODO 使用MyBatis查询共有多少个用户？
		//Integer num = mapper.getUserNum();
		//System.out.println(num);
		//TODO	salt=\u4F60\u559C\u6B22\u7F16\u7A0B\u5417
		
		
	}
	@Test
	public void testInsertUser() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml","spring-service.xml");
		System.out.println("===========");
		//2.取得Usermapper接口的实现类
		UserMapper mapper = ac.getBean("userMapper",UserMapper.class);
	
		//3.执行数据查询
		User user = new User();
		user.setUsername("test04");
		user.setPassword("abcd1234");
		user.setEmail("test03@126.com");
		user.setPhone("12312312311");
		mapper.insert(user);
		}
}
