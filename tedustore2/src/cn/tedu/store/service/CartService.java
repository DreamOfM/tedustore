package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
@Service
public class CartService implements ICartService{
	@Autowired
CartMapper cartMapper;
	@Override
	public List<Cart> getCarts(Integer userid) {
		// TODO Auto-generated method stub
		
		List<Cart> carts=cartMapper.getCartsByUserId(userid);
		if(carts!=null)
		return carts;
		
		return null;
	}
	@Override
	public void deleteCart(Integer cid) {
		// TODO Auto-generated method stub
		cartMapper.deleteCart(cid);
	}
	@Override
	public void deleteByItems(Integer[] itemIds) {
		// TODO Auto-generated method stub
		cartMapper.deleteByItems(itemIds);
	}
	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		cartMapper.addCart(cart);
		
	}
	@Override
	public Cart getCartsByid(Integer id) {
		// TODO Auto-generated method stub
		return cartMapper.getCartsByid(id);
	}

}
