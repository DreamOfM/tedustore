package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IGoodsService;




@Controller
@RequestMapping("/cart")
public class CartsController {
	/*Integer userid*/
	@Autowired
	ICartService cartSerivce;
	@Autowired
	IGoodsService goodsService;
	
	
	
	/**
	 * 添加到购物车
	 * @param session
	 * @param goodsId
	 * @param count
	 * @return
	 */
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session, Integer goodsId, Integer count) {
		Cart cart = new Cart();
		cart.setCount(count);
		cart.setGoodsid(goodsId);
		User user=(User)session.getAttribute("user");
		cart.setUserid(user.getId());
		cartSerivce.addCart(cart);
		return new ResponseResult<Void>(1, "加入购物车成功！");
	}

	
	@RequestMapping("/showCart")
	public String showCart(HttpSession session,Map map) {
		User user=(User)session.getAttribute("user");
		if(user==null) {
			return "cart";
		}
		System.out.println(user.getId());
		List<Cart> listCarts=cartSerivce.getCarts(user.getId());
	
	List<Goods> listGoods=new ArrayList<Goods>();
	for (Cart c : listCarts) {
		
		listGoods.add(goodsService.getGoodsById(c.getGoodsid()));
		
	}
	 map.put("listGoods", listGoods);
		map.put("listCarts", listCarts);
		
		
		return "cart";
	}
	/**
	 * 删除单个订单
	 * @param cid
	 * @param map
	 * @return
	 */
	@RequestMapping("/deleteCart")
	public String deleteCart(Integer cid,Map map) {
		cartSerivce.deleteCart(cid);
		
		
		return "redirect:showCart.do";
	}
	
	/**
	 * 根据多个id删除购物车商品
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteByitemIds")
	public String deleteByitemIds(Integer[] itemIds) {
		System.out.println("ddd");
		System.out.println(itemIds);
		cartSerivce.deleteByItems(itemIds);
		return "redirect:showCart.do";
	}
	
	/**
	 * 购物车里增加或减少商品数量
	 * @param id
	 * @param count
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping("/updateCountById.do")
	public ResponseResult<Void> updateCountById(Integer id, Integer count) {
		Cart cart = new Cart();
		cart.setCount(count);
		cart.setId(id);
		cartSerivce.updateCountById(cart);
		return new ResponseResult<Void>(1);
	}*/
	

}
