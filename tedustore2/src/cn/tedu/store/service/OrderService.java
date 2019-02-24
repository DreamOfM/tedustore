package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.OrderMapper;


@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private CartMapper cartMapper;

	@Override
	public Integer addOrder(Integer userId, List<Cart> carts,HttpSession session) {
		Order order = new Order();
		order.setUserId(userId);
		System.out.println(order);
		orderMapper.insertOrder(order);
		Integer orderId = order.getId();
		System.out.println(userId);
		OrderItem orderItem = new OrderItem();
		List<OrderItem> listoi=new ArrayList<OrderItem>();
		for (Cart c : carts) {  
			Goods goods=goodsMapper.getGoodsById(c.getGoodsid());
			orderItem.setUserId(userId);
		  orderItem.setGoodsId(goods.getId());
		  orderItem.setImage(goods.getImage());
			orderItem.setTitle(goods.getTitle());
			orderItem.setPrice(goods.getPrice());
			orderItem.setCount(c.getCount());
			orderItem.setOrderId(orderId);
			System.out.println(orderItem);
			orderMapper.insertOrderItem(orderItem);
			listoi.add(orderItem);
			cartMapper.deleteCart(c.getId());
			
		}
		session.setAttribute("listoi", listoi);
		return orderId;
		
	}

	@Override
	public void updateStatus(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> selectOrderItems(Integer userId) {
		return orderMapper.selectOrderItems(userId);
	}
	
	/*
	public Integer addOrder(Integer userId, List<CartVo> cartVos) {
		Order order = new Order(null,null,userId);
		orderMapper.insertOrder(order);
		Integer orderId = order.getId();
		OrderItem orderItem = new OrderItem();
		for (CartVo cartVo : cartVos) {
			orderItem.setUserId(userId);
			orderItem.setGoodsId(cartVo.getGoodsId());
			orderItem.setImage(cartVo.getImage());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setCount(cartVo.getCount());
			orderItem.setOrderId(orderId);
			orderMapper.insertOrderItem(orderItem);
		}
		return orderId;
	}*/
/*

	public void updateStatus(Integer orderId) {
		orderMapper.updateStatus(orderId);
	}


	public List<OrderItemVo> selectOrderItems(Integer userId) {
		return orderMapper.selectOrderItems(userId);
	}*/

}
