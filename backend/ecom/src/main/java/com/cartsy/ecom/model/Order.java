package com.cartsy.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "id")
	int id;

	@Column(name = "buyer_id")
	int buyer_id;

	@Column(name = "seller_id")
	int seller_id;

	@Column(name = "product_id")
	int product_id;

	@Column(name = "price")
	int price;

	@Column(name = "mode_of_payment")
	String mode_of_payment;

	@Column(name = "date_of_order")
	Date date_of_order;

	@Column(name = "shipping_address")
	String shipping_address;

	@Column(name = "date_of_shipment")
	Date date_of_shipment;

	@Column(name = "date_of_delivery")
	Date date_of_delivery;

	@Column(name = "order_status")
	String order_status;

	@Column(name = "tracking_number")
	String tracking_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMode_of_payment() {
		return mode_of_payment;
	}

	public void setMode_of_payment(String mode_of_payment) {
		this.mode_of_payment = mode_of_payment;
	}

	public Date getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(Date date_of_order) {
		this.date_of_order = date_of_order;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public Date getDate_of_shipment() {
		return date_of_shipment;
	}

	public void setDate_of_shipment(Date date_of_shipment) {
		this.date_of_shipment = date_of_shipment;
	}

	public Date getDate_of_delivery() {
		return date_of_delivery;
	}

	public void setDate_of_delivery(Date date_of_delivery) {
		this.date_of_delivery = date_of_delivery;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

}
