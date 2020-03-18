package com.sapient.catalog.search.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.catalog.search.entity.ProductEntity;
import com.sapient.catalog.search.model.Product;
import com.sapient.catalog.search.repository.ProductRepository;
import com.sapient.catalog.search.translator.ProductTranslator;
import com.sapient.catalog.search.utilities.SAppsUtil;
import com.sapient.catalog.search.utilities.ProductValidator;

@Service
public class ProductSearchServiceImpl implements ProductSearchService {

	Logger logger = LoggerFactory.getLogger(ProductSearchServiceImpl.class);

	private final SAppsUtil util;
	private final ProductValidator validator;
	private final ProductTranslator productTranslator;
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductSearchServiceImpl(ProductRepository productRepository, ProductTranslator productTranslator,
			ProductValidator validator, SAppsUtil util) {
		this.productRepository = productRepository;
		this.productTranslator = productTranslator;
		this.validator = validator;
		this.util = util;
	}
	
	public List<Product> getProductList(List<String> brandIds, List<String> productSkus, List<String> productSizeIds) {
		
		List<Product> products = new ArrayList<>();
		List<ProductEntity> productEntities = null;
		if (validator.isValidBrandIds(brandIds) && validator.isValidProductSkus(productSkus)
				&& validator.isValidSizeIds(productSizeIds)) {	
			productEntities = getProductEntities(brandIds, productSkus, productSizeIds);
		}
		if (CollectionUtils.isNotEmpty(productEntities)) {
			products = productTranslator.getProducts(productEntities);
		}
		return products;
	}
	
	
	////////////////////////////////////////////////
	///////Private
	////////////////////////////////////////////////
	
	private List<ProductEntity> getProductEntities(List<String> brandIds, List<String> productSkus, List<String> productSizeIds) {
		List<ProductEntity> productEntities = null;
		
		List<Long> brandIdVals = util.getLongs(brandIds);	
		List<Long> productSizeIdVals = util.getLongs(productSizeIds);
		
		// All three parameters are present
		if (CollectionUtils.isNotEmpty(brandIdVals) && CollectionUtils.isNotEmpty(productSizeIdVals)
				&& CollectionUtils.isNotEmpty(productSkus)) {
			productEntities = productRepository.findByBrandIdInAndSizeIdInAndProductSkuIn(brandIdVals, productSizeIdVals, productSkus);
		} 
		// If any parameters two are present
		else if (CollectionUtils.isNotEmpty(brandIdVals) && CollectionUtils.isNotEmpty(productSizeIdVals)
				&& CollectionUtils.isEmpty(productSkus)) {
			productEntities = productRepository.findByBrandIdInAndSizeIdIn(brandIdVals, productSizeIdVals);
		}
		else if (CollectionUtils.isNotEmpty(brandIdVals) && CollectionUtils.isEmpty(productSizeIdVals)
				&& CollectionUtils.isNotEmpty(productSkus)) {
			productEntities = productRepository.findByBrandIdInAndProductSkuIn(brandIdVals, productSkus);
		}
		else if (CollectionUtils.isEmpty(brandIdVals) && CollectionUtils.isNotEmpty(productSizeIdVals)
				&& CollectionUtils.isNotEmpty(productSkus)) {
			productEntities = productRepository.findBySizeIdInAndProductSkuIn(productSizeIdVals, productSkus);
		} 
		// If any one parameter is present
		else if (CollectionUtils.isNotEmpty(brandIdVals) && CollectionUtils.isEmpty(productSizeIdVals)
				&& CollectionUtils.isEmpty(productSkus)) {
			productEntities = productRepository.findByBrandIdIn(brandIdVals);
		} else if (CollectionUtils.isEmpty(brandIdVals) && CollectionUtils.isNotEmpty(productSizeIdVals)
				&& CollectionUtils.isEmpty(productSkus)) {
			productEntities = productRepository.findBySizeIdIn(productSizeIdVals);
		}  else if (CollectionUtils.isEmpty(brandIdVals) && CollectionUtils.isEmpty(productSizeIdVals)
				&& CollectionUtils.isNotEmpty(productSkus)) {
			productEntities = productRepository.findByProductSkuIn(productSkus);
		} 
		// If no parameters are present
		else if (CollectionUtils.isEmpty(brandIdVals) && CollectionUtils.isEmpty(productSizeIdVals)
				&& CollectionUtils.isEmpty(productSkus)) {
			productEntities = productRepository.findAll();
		}
		return productEntities;
	}
	
}
