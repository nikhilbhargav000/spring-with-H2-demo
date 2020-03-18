package com.sapient.catalog.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="products")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class ProductEntity {

	@Id
	@Column(name="p_id")
	private long pId;
	
	@Column(name="p_name")
	private String pName;
	
	@Column(name="brand_id")
	private long brandId;

	@Column(name="brand_name")
	private String brandName;	
	
	@Column(name="category_id")
	private long categoryId;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="size_id")
	private long sizeId;

	@Column(name="size_name")
	private String sizeName;

	@Column(name="product_sku")
	private String productSku;

	@Column(name="")
	private String colour;
	
	@Column(name="price")
	private String price;
	
	@Column(name="availble")
	private String availble;
}
