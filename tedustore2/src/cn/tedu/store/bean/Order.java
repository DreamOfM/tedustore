package cn.tedu.store.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;      //订单

    private Integer userId;

    private Integer addressId;

    private Double payment;

    private Integer paymentStatus;
 

    private Integer shipping_status;

    private Date receipTime;    //付款时间

    private Date tradeTime;  //下单时间

    private Date deliverTime;   //发货时间
 
    private Date handoverTime;   //确认收获时间
    
    public Order() {
		// TODO Auto-generated constructor stub
	}
public Order(Object object, Object object2, Integer userId2) {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Order [id=" + id + ", userId=" + userId + ", addressId=" + addressId + ", payment=" + payment
			+ ", paymentStatus=" + paymentStatus + ", shipping_status=" + shipping_status + ", receipTime=" + receipTime
			+ ", tradeTime=" + tradeTime + ", deliverTime=" + deliverTime + ", handoverTime=" + handoverTime + "]";
}
public Integer getId() {
	return id;
}

public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}
public Double getPayment() {
	return payment;
}
public void setPayment(Double payment) {
	this.payment = payment;
}
public Integer getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(Integer paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public Integer getShipping_status() {
	return shipping_status;
}
public void setShipping_status(Integer shipping_status) {
	this.shipping_status = shipping_status;
}
public Date getReceipTime() {
	return receipTime;
}
public void setReceipTime(Date receipTime) {
	this.receipTime = receipTime;
}
public Date getTradeTime() {
	return tradeTime;
}
public void setTradeTime(Date tradeTime) {
	this.tradeTime = tradeTime;
}
public Date getDeliverTime() {
	return deliverTime;
}
public void setDeliverTime(Date deliverTime) {
	this.deliverTime = deliverTime;
}
public Date getHandoverTime() {
	return handoverTime;
}
public void setHandoverTime(Date handoverTime) {
	this.handoverTime = handoverTime;
}

}


   