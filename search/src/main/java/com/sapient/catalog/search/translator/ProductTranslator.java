package com.sapient.catalog.search.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.sapient.catalog.search.entity.ProductEntity;
import com.sapient.catalog.search.model.Product;

@Component
public class ProductTranslator {
	
	public Product getProduct(ProductEntity productEntity) {
		return new Product(productEntity.getPId(), productEntity.getPName(), productEntity.getBrandId(),
				productEntity.getBrandName(), productEntity.getCategoryId(), productEntity.getCategoryName(),
				productEntity.getSizeId(), productEntity.getSizeName(), productEntity.getProductSku(),
				productEntity.getColour(), productEntity.getPrice(), productEntity.getAvailble());
	}
	/**
	 * Using Java 8 stream feature
	 * @param productEntities
	 * @return
	 */
	public List<Product> getProducts (List<ProductEntity> productEntities) {
		List<Product> products = new ArrayList<Product>();
		if (CollectionUtils.isEmpty(productEntities)) {
			return products;
		}
		productEntities.forEach((productEntity)-> {
			products.add(getProduct(productEntity));
		});
		return products;
	}
	
}
