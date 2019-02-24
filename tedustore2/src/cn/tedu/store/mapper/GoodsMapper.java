package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPictures;
import cn.tedu.store.bean.GoodsSpecVO;
import cn.tedu.store.bean.GoodsVO;

public interface GoodsMapper {
	/**
	 * 获得某个类别下  多个商品信息
	 */
	List<GoodsVO> getGoodsVOByCategoryId(
			@Param("categoryId")Integer categoryId,
			@Param("offset")Integer offset,
			@Param("count")Integer count);
		/**
		 * 根据商品类别categoryId查询商品
		 * @param categoryId
		 * @param offset
		 * @param count
		 * @return
		 */
		List<Goods> getGoodsByCategoryId(
				@Param("categoryId")Integer categoryId,
				@Param("offset")Integer offset,
				@Param("count")Integer count
				);
		/**
		 * 查询某类商品行数
		 * @param categoryId
		 * @return
		 */
		Integer getCount(Integer categoryId);
		/**
		 * 搜索商品
		 * @param title
		 * @param offset
		 * @param count
		 * @return
		 */
		List<Goods> getGoodsByTitle(
				@Param("title")String title,
				@Param("offset")Integer offset,
				@Param("count")Integer count
				);
		/**
		 * 搜索商品行数
		 * @param title
		 * @return
		 */
		Integer getCountByTitle(String title);
		
		/**
		 * 通过id查询单个商品详情
		 * @param id
		 * @return
		 */
		Goods getGoodsById(Integer id);
		List<GoodsPictures> getGoodspicByGoodsId(Integer id);
		List<GoodsSpecVO> getGoodsSpecVOByGoodsId(Integer id);
		List<GoodsVO> getGoodsVOByGoodsIdAndCategoryId(@Param("goodsId")Integer goodsId,@Param("categoryId")Integer categoryId);
	}

	

