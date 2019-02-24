package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

@Service
public class GoodsCategoryService implements IGoodsCategoryService{

	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	@Override
	public List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId, Integer offset, Integer count) {
		
		return goodsCategoryMapper.getGoodsCategoryByParentId(parentId, offset, count);
	}

	@Override
	public GoodsCategory getGoodsCategoryById(Integer id) {
		
		return goodsCategoryMapper.getGoodsCategoryById(id);
	}

}
