package com.cartsy.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyers")
public class Buyer {

	@Id
	@Column(name = "id")
	int id;

	@Column(name = "buyer_name")
	String buyer_name;

	@Column(name = "buyer_phone")
	String buyer_phone;

	@Column(name = "buyer_email")
	String buyer_email;

	@Column(name = "buyer_payment_options")
	String buyer_payment_options;

	@Column(name = "buyer_addresses")
	String buyer_addresses;

	@Column(name = "buyer_doj")
	Date buyer_doj;

	@Column(name = "buyer_status")
	String buyer_status;

	@Column(name = "buyer_rating")
	String buyer_rating;

	@Column(name = "buyer_profile_pic")
	String buyer_profile_pic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getBuyer_phone() {
		return buyer_phone;
	}

	public void setBuyer_phone(String buyer_phone) {
		this.buyer_phone = buyer_phone;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getBuyer_payment_options() {
		return buyer_payment_options;
	}

	public void setBuyer_payment_options(String buyer_payment_options) {
		this.buyer_payment_options = buyer_payment_options;
	}

	public String getBuyer_addresses() {
		return buyer_addresses;
	}

	public void setBuyer_addresses(String buyer_addresses) {
		this.buyer_addresses = buyer_addresses;
	}

	public Date getBuyer_doj() {
		return buyer_doj;
	}

	public void setBuyer_doj(Date buyer_doj) {
		this.buyer_doj = buyer_doj;
	}

	public String getBuyer_status() {
		return buyer_status;
	}

	public void setBuyer_status(String buyer_status) {
		this.buyer_status = buyer_status;
	}

	public String getBuyer_rating() {
		return buyer_rating;
	}

	public void setBuyer_rating(String buyer_rating) {
		this.buyer_rating = buyer_rating;
	}

	public String getBuyer_profile_pic() {
		return buyer_profile_pic;
	}

	public void setBuyer_profile_pic(String buyer_profile_pic) {
		this.buyer_profile_pic = buyer_profile_pic;
	}

}
