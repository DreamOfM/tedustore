package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

/**
 * 地址业务层
 * @author yyj37
 *
 */
public interface IAddressService {
	/**
	 * 添加地址
	 * @param address
	 */
	void addAddress(Address address);
	
	/**
	 * 根据Uid查询地址
	 * @param id
	 * @return
	 */
	List<Address> getAllAddressByUid(Integer id);
	
	/**
	 * 根据uId设为非默认
	 * 根据id设为默认
	 */
	void setDefault(Integer id,Integer uId);
	
	/**
	 * 根据id获取地址
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	
	/**
	 * 修改地址信息
	 * @param address
	 */
	void updateAddress(Address address);
	
	/**
	 * 删除地址信息
	 * @param id
	 */
	void deleteAddress(Integer id);
}
