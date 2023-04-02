package com.cartsy.ecom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
public class Seller {

	@Id
	@Column(name = "id")
	int id;

	@Column(name = "seller_name")
	String seller_name;

	@Column(name = "seller_tin")
	String seller_tin;

	@Column(name = "seller_rating")
	String seller_rating;

	@Column(name = "seller_address")
	String seller_address;

	@Column(name = "seller_phone")
	String seller_phone;

	@Column(name = "seller_email")
	String seller_email;

	@Column(name = "seller_doj")
	Date seller_doj;

	@Column(name = "seller_status")
	String seller_status;

	@Column(name = "seller_profile_pic")
	String seller_profile_pic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getSeller_tin() {
		return seller_tin;
	}

	public void setSeller_tin(String seller_tin) {
		this.seller_tin = seller_tin;
	}

	public String getSeller_rating() {
		return seller_rating;
	}

	public void setSeller_rating(String seller_rating) {
		this.seller_rating = seller_rating;
	}

	public String getSeller_address() {
		return seller_address;
	}

	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}

	public String getSeller_phone() {
		return seller_phone;
	}

	public void setSeller_phone(String seller_phone) {
		this.seller_phone = seller_phone;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public Date getSeller_doj() {
		return seller_doj;
	}

	public void setSeller_doj(Date seller_doj) {
		this.seller_doj = seller_doj;
	}

	public String getSeller_status() {
		return seller_status;
	}

	public void setSeller_status(String seller_status) {
		this.seller_status = seller_status;
	}

	public String getSeller_profile_pic() {
		return seller_profile_pic;
	}

	public void setSeller_profile_pic(String seller_profile_pic) {
		this.seller_profile_pic = seller_profile_pic;
	}

}
