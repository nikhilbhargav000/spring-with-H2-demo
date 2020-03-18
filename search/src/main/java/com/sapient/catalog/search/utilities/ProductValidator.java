package com.sapient.catalog.search.utilities;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sapient.catalog.search.expection.SAppsRuntimeException;
import com.sapient.catalog.search.repository.BrandRepository;
import com.sapient.catalog.search.repository.ProductRepository;
import com.sapient.catalog.search.repository.SizeRepository;

@Component
public class ProductValidator {

	private final BrandRepository brandRepository;
	private final SizeRepository sizeRepository;
	private final ProductRepository productRepository;
	private final SAppsUtil util;
	
	@Autowired
	public ProductValidator(BrandRepository brandRepository, SizeRepository sizeRepository, 
			ProductRepository productRepository, SAppsUtil util) {
		this.brandRepository = brandRepository;
		this.sizeRepository = sizeRepository;
		this.productRepository = productRepository;
		this.util = util;
	}
	
	public boolean isValidBrandIds(List<String> brandIds) {
		if (CollectionUtils.isEmpty(brandIds)) {
			return true;
		}
		brandIds.stream().forEach((brandId) -> {
			if (!util.isValidLong(brandId) || !brandRepository.findById(Long.parseLong(brandId)).isPresent()) {
				throw new SAppsRuntimeException(HttpStatus.BAD_REQUEST.value(), "Invalid brand id");
			}
		});
		return true;
	}

	public boolean isValidSizeIds(List<String> sizeIds) {
		if (CollectionUtils.isEmpty(sizeIds)) {
			return true;
		}
		sizeIds.stream().forEach((sizeId) -> {
			if (!util.isValidLong(sizeId) || !sizeRepository.findById(Long.valueOf(sizeId)).isPresent()) {
				throw new SAppsRuntimeException(HttpStatus.BAD_REQUEST.value(), "Invalid size id");
			}
		});
		return true;
	}

	public boolean isValidProductSkus(List<String> productSkus) {
		if (CollectionUtils.isEmpty(productSkus)) {
			return true;
		}
		productSkus.stream().forEach((productSku) -> {
			if (Strings.isEmpty(productSku)
					|| CollectionUtils.isEmpty(productRepository.findByProductSku(productSku))) {
				throw new SAppsRuntimeException(HttpStatus.BAD_REQUEST.value(), "Invalid product sku");
			}
		});
		return true;
	}
	
}
