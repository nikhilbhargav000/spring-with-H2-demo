package com.sapient.catalog.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="sizes")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class SizeEntity {
	
	@Id
	@Column(name="s_id")
	private long sId;
	
	@Column(name="size_name")
	private String sizeName;
	
}
