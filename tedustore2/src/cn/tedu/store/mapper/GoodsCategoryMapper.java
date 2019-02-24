package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {

	
	/**
	 * 查询parentId下所有的子类别信息
	 * @param parentId  父类别的id
	 * @param offset		从指定下标开始取记录
	 * @param count   取出多少条记录
	 * @return
	 */
	List<GoodsCategory> getGoodsCategoryByParentId(
			@Param("parentId")Integer parentId,
			@Param("offset")Integer offset,
			@Param("count")Integer count);
	
	//当mybatis查询需要使用多个参数值时，
	//@param注解，用于声明参数的绑定名
	
	/**
	 * 根据类别id，查询出某个类别的详细信息
	 * @param id
	 * @return
	 */
	GoodsCategory getGoodsCategoryById(Integer id);
	

}
