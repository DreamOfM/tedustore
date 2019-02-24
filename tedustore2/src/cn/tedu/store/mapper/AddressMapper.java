package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	
	/**
	 * 插入地址
	 * @param address
	 */
	void insert(Address address);
	
	/**
	 * 根据Uid查询地址
	 * @param id
	 * @return
	 */
	List<Address> getAddressByUid(Integer userId);
	
	/**
	 * 根据uId设为非默认
	 * @param uId
	 * @return
	 */
	void setCancel(Integer uId);
	
	/**
	 * 根据id设为默认
	 * @param id
	 * @return
	 */
	void setDefault(Integer id);
	
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
	void update(Address address);
	
	/**
	 * 删除地址信息
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);
	
}
