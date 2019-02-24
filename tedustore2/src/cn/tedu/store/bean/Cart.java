package cn.tedu.store.bean;

import java.io.Serializable;

public class Cart implements Serializable{
	private Integer id;
	private Integer goodsid;
	private Integer userid;
	private Integer count;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Carts [id=" + id + ", goodsid=" + goodsid + ", userid=" + userid + ", count=" + count + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}
