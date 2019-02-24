package cn.tedu.store.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPictures;
import cn.tedu.store.bean.GoodsSpecVO;
import cn.tedu.store.bean.GoodsVO;

public interface IGoodsService {

	List<GoodsVO> getGoodsVOByCategoryId(
			Integer categoryId,
			Integer offset, 
			Integer count);
	/**
	 * 根据CategoryId查询商品
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByCategoryId(
			Integer categoryId,
			Integer offset,
			Integer count
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
			String title,
			Integer offset,
			Integer count
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
	/**
	 * 通过商品id查询商品的图片
	 * @param id
	 * @return
	 */
	List<GoodsPictures> getGoodspicByGoodsId(Integer id);
	List<GoodsSpecVO> getGoodsSpecVOByGoodsId(Integer id);
	List<GoodsVO> getGoodsVOByGoodsIdAndCategoryId(@Param("goodsId")Integer goodsId,@Param("categoryId")Integer categoryId);
}
