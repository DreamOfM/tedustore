package cn.tedu.store.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPictures;
import cn.tedu.store.bean.GoodsSpecVO;
import cn.tedu.store.bean.GoodsVO;
import cn.tedu.store.mapper.GoodsMapper;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	//获得某个类别下  多个商品信息
	@Override
	public List<GoodsVO> getGoodsVOByCategoryId(Integer categoryId, Integer offset, Integer count) {
		
		//业务数据有效性判断
		if(categoryId == null) {
			throw new RuntimeException("商品类别不能为空");
			
		}
		//业务处理
		return goodsMapper.getGoodsVOByCategoryId(categoryId, offset, count);
	}
	
	
	 //根据商品类别categoryId查询商品
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		return goodsMapper.getGoodsByCategoryId(categoryId, offset, count);
	}

	//查询某类商品行数
	public Integer getCount(Integer categoryId) {
		return goodsMapper.getCount(categoryId);
	}

	//根据商品标题title搜索商品
	public List<Goods> getGoodsByTitle(String title, Integer offset, Integer count) {
		return goodsMapper.getGoodsByTitle(title, offset, count);
	}

	//搜索商品行数
	public Integer getCountByTitle(String title) {
		return goodsMapper.getCountByTitle(title);
	}

	//通过id查询单个商品详情
	@Override
	public Goods getGoodsById(Integer id) {
		return goodsMapper.getGoodsById(id);
	}


	@Override
	public List<GoodsPictures> getGoodspicByGoodsId(Integer id) {
		
		return goodsMapper.getGoodspicByGoodsId(id);
	}


	@Override
	public List<GoodsSpecVO> getGoodsSpecVOByGoodsId(Integer id) {		
		return goodsMapper.getGoodsSpecVOByGoodsId(id);
	}


	@Override
	public List<GoodsVO> getGoodsVOByGoodsIdAndCategoryId(@Param("goodsId")Integer goodsId,@Param("categoryId")Integer categoryId) {
		
		return goodsMapper.getGoodsVOByGoodsIdAndCategoryId(goodsId, categoryId);
	}

}
