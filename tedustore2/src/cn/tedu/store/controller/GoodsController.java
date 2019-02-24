package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsPictures;
import cn.tedu.store.bean.GoodsSpecVO;
import cn.tedu.store.bean.GoodsVO;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController{
	
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	
	@Resource
	private IGoodsService goodsService;
	
	/**
	 * 显示商品列表，
	 * @param categoryId
	 * @param page
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/showGoods.do")
	public String showGoods(Integer categoryId, Integer page, ModelMap modelMap) {
		if (page == null || page < 1) {
			page = 1;
		}
		List<Goods> goodses = goodsService.getGoodsByCategoryId(categoryId, ((page-1)*16), ProductCount.COUNT);
		Integer count = goodsService.getCount(categoryId);
		Integer pageNum = (count+15)/ProductCount.COUNT;
		System.out.println(goodses);
		modelMap.addAttribute("goodses", goodses);
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("pageNum", pageNum);
		modelMap.addAttribute("categoryId", categoryId);
		modelMap.addAttribute("page", page);
		return "search";
	}
	
	@RequestMapping("/showGoodsByTitle.do")
	public String showGoodsByTitle(String title, Integer page, ModelMap modelMap){
		System.out.println(title);
		Integer count = goodsService.getCountByTitle(title);
		if (page == null || page <1) {
			page = 1;
		}
		Integer pageNum = (count + ProductCount.COUNT-1)/16;
		List<Goods> goodses = goodsService.getGoodsByTitle(title, (page-1)*16, ProductCount.COUNT);
		modelMap.addAttribute("goodses", goodses);
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("pageNum", pageNum);
		modelMap.addAttribute("title", title);
		modelMap.addAttribute("page", page);
		return "search";
	}
	
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(Integer id, ModelMap modelMap,Integer categoryId) {
		Goods goods = goodsService.getGoodsById(id);
		List<GoodsVO> goodses = goodsService.getGoodsVOByGoodsIdAndCategoryId(id, categoryId);
		List<GoodsPictures> listPic = goodsService.getGoodspicByGoodsId(id);
		List<GoodsSpecVO> listSeries = goodsService.getGoodsSpecVOByGoodsId(id);
		modelMap.addAttribute("listPic",listPic);
		modelMap.addAttribute("listSeries",listSeries);
		System.out.println(listPic);
		System.out.println(listSeries);
		modelMap.addAttribute("goods", goods);
		modelMap.addAttribute("goodses", goodses);
		System.out.println(goodses);
		return "product_details";
	}
	
	
	
}
