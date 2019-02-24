package cn.tedu.store.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Order;


/**
 * 订单业务层
 * @author yyj37
 *
 */
public interface IOrderService {

	/**
	 * 添加订单
	 * @param userId
	 * @param cartVos
	 */
	Integer addOrder(Integer userId, List<Cart> carts,HttpSession session);
	
	/**
	 * 修改支付状态为已支付
	 * @param orderId
	 */
	void updateStatus(Integer orderId);
	
	/**
	 * 查询订单详情
	 * @param userId
	 * @return
	 */
	List<Order> selectOrderItems(Integer userId);
	
}



