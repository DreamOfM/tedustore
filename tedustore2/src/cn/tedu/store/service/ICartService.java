package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;

public interface ICartService {

	List<Cart> getCarts(Integer userid);

	void deleteCart(Integer cid);

	void deleteByItems(Integer[] itemIds);

	void addCart(Cart cart);



	Cart getCartsByid(Integer id);



}
