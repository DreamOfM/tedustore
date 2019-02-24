package cn.tedu.store.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.GoodsVO;
import cn.tedu.store.service.GoodsCategoryService;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;


//商城首页相关的功能
@Controller
@RequestMapping("/main")

public class MainController implements Serializable{
	
	@Autowired
	private IGoodsCategoryService goodsCategoryService;
	
	@Autowired
	private IGoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	public String showIndex(Map<String,Object> map) {
		
			//查询   电脑，办公/1F   这个类别下的子类别
		List<GoodsCategory> list1F = goodsCategoryService.getGoodsCategoryByParentId(161,0,3);
			/*for(GoodsCategory c : list1F) {
				System.out.println(c);
			}*/
		//161电脑办公的子类别：162    171  186
		
		
		List<List<GoodsCategory>> list1FSubs = new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory c : list1F) {
				Integer parentId = c.getId();
				List<GoodsCategory> list = goodsCategoryService.getGoodsCategoryByParentId(parentId,0,6);
				list1FSubs.add(list);
		}
		//查询商品的category_id是163的三个商品
		List<GoodsVO> list1FGoods = goodsService.getGoodsVOByCategoryId(163,0,3); 	
		map.put("list1F", list1F);
		map.put("list1FGoods", list1FGoods);
		map.put("list1FSubs", list1FSubs);
		//办公文具/2F
		//显示以下三个类别的子类别  229   210   202
		List<GoodsCategory> list2F = new ArrayList<GoodsCategory>();
		list2F.add(goodsCategoryService.getGoodsCategoryById(229));
		list2F.add(goodsCategoryService.getGoodsCategoryById(210));
		list2F.add(goodsCategoryService.getGoodsCategoryById(202));
		List<List<GoodsCategory>> list2FSubs = new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory c : list2F) {
				Integer parentId = c.getId();
				List<GoodsCategory> list = goodsCategoryService.getGoodsCategoryByParentId(parentId,0,6);
				list2FSubs.add(list);
		}
		//查询商品的category_id是163的三个商品
		List<GoodsVO> list2FGoods = goodsService.getGoodsVOByCategoryId(163,0,3);
		map.put("list2F", list2F);
		map.put("list2FGoods", list2FGoods);
		map.put("list2FSubs", list2FSubs);
		return "index";
		}
}
