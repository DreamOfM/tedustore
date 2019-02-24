package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;

/**
 * 订单持久层
 * @author yyj37
 *
 */
public interface OrderMapper {
	
	/**
	 * 插入订单
	 * @param order
	 * @return
	 */
	void insertOrder(Order order);
	
	/**
	 * 插入订单详情
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
	
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
