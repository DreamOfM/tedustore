package cn.tedu.store.mapper;

import java.util.List;

import org.apache.catalina.startup.Catalina;
import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.GoodsCategory;
/**
 * 查询parengId下所有的子类别信息
 * @param parentId 父类别的id
 * offset 从指定下标开始取记录
 * count 取出多少条记录
 * @author soft01
 *
 */
public interface CartMapper {
	//当mybatis查询需要使用多个参数值时，
	//@Param注解，用于声明传入参数的绑定名
	List<Cart> getCartsByUserId(
			Integer userid);
	//GoodsCategory getGoodsCategoryById(Integer id);
	//void deleteCart(Integer )

	void deleteCart(Integer cid);

	void deleteByItems(Integer[] itemIds);

	void addCart(Cart cart);
	Cart getCartsByid(Integer id);
}
