package com.cartsy.ecom.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="products")
public class Product {


    @Id
    int id;
    @Column(name = "product_s_desc")
    String product_s_desc; 
    @Column(name = "product_l_desc")
    String product_l_desc ;
    @Column(name = "product_actual_price")
    int product_actual_price; 
    @Column(name = "product_sale_price")
    int product_sale_price ;
    @Column(name = "product_images")
    String product_images ;
    @Column(name = "seller_id")
    int seller_id ;
    @Column(name = "quantity")
    int quantity ;
    @Column(name = "color")
    String color;
    @Column(name = "brand")
    String brand ;
    @Column(name = "first_available")
    Date first_available;
    @Column(name = "created_date")
    Date created_date;
    @Column(name = "category_id")
    int category_id;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_s_desc() {
		return product_s_desc;
	}
	public void setProduct_s_desc(String product_s_desc) {
		this.product_s_desc = product_s_desc;
	}
	public String getProduct_l_desc() {
		return product_l_desc;
	}
	public void setProduct_l_desc(String product_l_desc) {
		this.product_l_desc = product_l_desc;
	}
	public int getProduct_actual_price() {
		return product_actual_price;
	}
	public void setProduct_actual_price(int product_actual_price) {
		this.product_actual_price = product_actual_price;
	}
	public int getProduct_sale_price() {
		return product_sale_price;
	}
	public void setProduct_sale_price(int product_sale_price) {
		this.product_sale_price = product_sale_price;
	}
	public String getProduct_images() {
		return product_images;
	}
	public void setProduct_images(String product_images) {
		this.product_images = product_images;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getFirst_available() {
		return first_available;
	}
	public void setFirst_available(Date first_available) {
		this.first_available = first_available;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
}
