package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.IOrderService;



/**
 * 订单
 * @author yyj37
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController   {

	@Autowired
	private ICartService cartService;
	@Autowired
	private IGoodsService goodsService;
	
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private IOrderService orderService;

	/**
	 * 显示订单页面
	 * @param session
	 * @param ids
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpSession session, Integer[] id, ModelMap modelMap) {
		User user=(User)session.getAttribute("user");
		List<Cart> listCarts = cartService.getCarts(user.getId());
		System.out.println(listCarts);
		
		List<Goods> listGoods=new ArrayList<Goods>();
		for (Cart c : listCarts) {
			
			listGoods.add(goodsService.getGoodsById(c.getGoodsid()));
			
		}
		session.setAttribute("listCarts", listCarts);
		modelMap.addAttribute("listCarts", listCarts);
		modelMap.addAttribute("listGoods", listGoods);
		List<Address> addresses = addressService.getAllAddressByUid(user.getId());
		modelMap.addAttribute("addresses", addresses);
		session.setAttribute("addresses", addresses);
		return "orders";
	}
	
	@RequestMapping("/showAddress.do")
	public String showAddress(HttpSession session, Integer[] id, ModelMap modelMap) {
		User user=(User)session.getAttribute("user");
		List<Cart> listCarts = cartService.getCarts(user.getId());
		System.out.println(listCarts);
		System.out.println("4564564541");
		List<Goods> listGoods=new ArrayList<Goods>();
		for (Cart c : listCarts) {
			
			listGoods.add(goodsService.getGoodsById(c.getGoodsid()));
			
		}
		session.setAttribute("listCarts", listCarts);
		modelMap.addAttribute("listCarts", listCarts);
		modelMap.addAttribute("listGoods", listGoods);
		List<Address> addresses = addressService.getAllAddressByUid(user.getId());
		modelMap.addAttribute("addresses", addresses);
		session.setAttribute("addresses", addresses);
		return "addressAdmin";
	}
	
	/**
	 * 生成订单并跳转支付页面
	 * @param session
	 * @return
	 */
	//@SuppressWarnings("unchecked")
	@RequestMapping("/payment.do")
	public String payment(Integer[] itemIds,HttpSession session) {
		User user=(User)session.getAttribute("user");
		// (List<CartVo>)session.getAttribute("cartVos")
		List<Cart> listCart=new ArrayList<Cart>();
		for (Integer i : itemIds) {
			listCart.add(cartService.getCartsByid(i));
			System.out.println(cartService.getCartsByid(i));
		}
		//cartService.getCartsByid();
		Integer orderId = orderService.addOrder(user.getId(),listCart,session);
		List<Order> ListOrder = orderService.selectOrderItems(user.getId());//new ArrayList<OrderItem>();
		session.setAttribute("orderId", orderId);
		return "orderConfirm";
	}
	
	/*@RequestMapping("/pay.do")
	public String pay(HttpSession session) {
		Integer orderId = (Integer)session.getAttribute("orderId");
	//	orderService.updateStatus(orderId);
		//session.removeAttribute("cartVos"); 
		//session.removeAttribute("orderId");
		return "pay_success";
	}
	*/
/*	@RequestMapping("/showOrderItem.do")
	public String showOrderItem(HttpSession session, ModelMap modelMap) {
		List<Order> orderItemVos = orderService.selectOrderItems(GetUid(session));
		modelMap.addAttribute("orderItemVos", orderItemVos);
		return "orders";
	}*/
	
	/**
	 * 暂不适用
	 * @param id
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/setDefault.do")
	public ResponseResult<Void> setDefault(Integer id) {
		System.out.println(id);
		return new ResponseResult<Void>(1);
	}
	*/
	
}
