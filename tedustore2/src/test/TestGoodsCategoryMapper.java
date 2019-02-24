package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.GoodsService;



public class TestGoodsCategoryMapper {

	@Test
	public void testGetGoodsCategoryByParentId() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml","spring-service.xml");
		System.out.println("=============");
		
		//2.测试
		GoodsCategoryMapper mapper = ac.getBean(GoodsCategoryMapper.class);
		List<GoodsCategory> list = mapper.getGoodsCategoryByParentId(161, 0, 3);
		for(GoodsCategory c : list) {
			System.out.println(c);
		}
		
		
		
		// 162       171     186
		List<GoodsCategory> list162 = mapper.getGoodsCategoryByParentId(162, 0, 6);
		for(GoodsCategory c : list162) {
			System.out.println(c);
		}
		
	}
	@Test
	public void testGetGoodsByParentId() {
		//1.获得Spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-dao.xml","spring-service.xml");
		System.out.println("=============");
		
		//2.测试
		GoodsService mapper = ac.getBean(GoodsService.class);
		Goods list = mapper.getGoodsById(14);
		
		System.out.println(list);
		/*for(GoodsCategory c : list) {
			System.out.println(c);
		}*/
		
		
		
		// 162       171     186
	}		
	

}
