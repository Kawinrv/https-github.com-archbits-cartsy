package com.cartsy.ecom.api.v1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="orders")
@JsonInclude(Include.NON_NULL)
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; 
	
	@NotNull()
	@Column(name = "buyer_id")
    Integer buyerId;
	
	@NotNull()
	@Column(name = "seller_id")
    Integer sellerId;
	
	@NotNull()
	@Column(name = "product_id")
    Integer productId;
	
	@NotNull()
	@Column(name = "price")
    Integer price;
	
	@NotNull()
	@Column(name = "mode_of_payment")
    String modeOfPayment;

	@NotNull()
	@Column(name = "date_of_order")
    Date dateOfOrder;
	
	@NotNull()
	@Column(name = "shipping_address")
    String shippingAddress;
	
	@Column(name = "date_of_shipment")
	Date dateOfShipment;
	
	@Column(name = "date_of_delivery")
	Date dateOfDelivery;
  
	@Column(name = "order_status")
    String orderStatus;
	
	@Column(name = "tracking_number")
    String trackingNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getDateOfShipment() {
		return dateOfShipment;
	}

	public void setDateOfShipment(Date dateOfShipment) {
		this.dateOfShipment = dateOfShipment;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}



}
