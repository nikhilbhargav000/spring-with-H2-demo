package com.sapient.catalog.search.service;

import java.util.List;

import com.sapient.catalog.search.model.Product;

public interface ProductSearchService {

	public List<Product> getProductList(List<String> brandIds, List<String> productSkus, List<String> productSizeIds) ;	
}
