package com.sapient.catalog.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="brands")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class BrandEntity {

	@Id
	@Column(name="b_id")
	private long bId;
	
	@Column(name="brand_name")
	private String brandName;
	
}
