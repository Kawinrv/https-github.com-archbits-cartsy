package com.cartsy.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "categories")
public class ProductCategory {

	@Id
	int id;

	@Column(name = "levels")
	String levels;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

=======
@Table(name="categories")
public class ProductCategory {
	
	@Id
	int id;
	
	@Column(name = "levels")
	String levels;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	
>>>>>>> f6f70ea71d4e49e7112b2457bb011d420ca94ef2
}
