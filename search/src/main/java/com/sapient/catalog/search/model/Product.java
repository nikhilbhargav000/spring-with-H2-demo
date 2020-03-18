package com.sapient.catalog.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class Product {

	private long pId;
	private String pName;
	private long brandId;
	private String brandName;
	private long categoryId;
	private String categoryName;
	
	private long sizeId;
	private String sizeName;
	
	private String productSku;
	
	private String colour;
	private String price;
	private String availble;
}
