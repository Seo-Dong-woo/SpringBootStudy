package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
 *  NO int 
	GOODS_NAME text 
	GOODS_SUB text 
	GOODS_PRICE text 
	GOODS_DISCOUNT int 
	GOODS_FIRST_PRICE text 
	GOODS_DELIVERY text 
	GOODS_POSTER text 
	HIT int
 */
@Entity(name = "goods_all")
@Data
public class GoodsAll {
	@Id
	private int no;
	@Column(name = "goods_name")
	private String name;
	@Column(name = "goods_sub")
	private String sub;
	@Column(name = "goods_price")
	private String price;
	@Column(name = "goods_discount")
	private String discount;
	@Column(name = "goods_first_price")
	private String fprice;
	@Column(name = "goods_delivery")
	private String delivery;
	@Column(name = "goods_poster")
	private String poster;
	private int hit;
}
