package com.sapient.catalog.search.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.catalog.search.model.Product;
import com.sapient.catalog.search.service.ProductSearchServiceImpl;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	private final ProductSearchServiceImpl productSearchService;

	@Autowired
	public ProductController(ProductSearchServiceImpl productSearchService) {
		this.productSearchService = productSearchService;
	}

	/**
	 * Client do 3 operations which includes search for brand, product-SKU or
	 * product-size based on their brandId, product-sku or sizeId which are excepted
	 * from client side
	 * 
	 * Refreshed data is provided after the data is updated after other endpoint or
	 * source.
	 * 
	 * @param brandIds
	 * @param productSkus
	 * @param productSizeIds
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProduct(
			@RequestParam(name = "brandId", required = false) List<String> brandIds,
			@RequestParam(name = "sku", required = false) List<String> productSkus,
			@RequestParam(name = "sizeId", required = false) List<String> productSizeIds) {

		return new ResponseEntity<List<Product>>(
				productSearchService.getProductList(brandIds, productSkus, productSizeIds), HttpStatus.OK);
	}

	/**
	 * Some other EndPoints
	 */

	/**
	 * Insert new product with appropriate category, size, brand and other details.
	 * 
	 * Data from multiple suppliers can be used using this endpoint.
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> createProduct(@RequestBody Product product) {
		return null;
	}

	/**
	 * Update the product details
	 */
	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
	public ResponseEntity<Long> updateProduct(@PathVariable(name = "productId") String prductId,
			@RequestBody Product product) {
		return null;
	}
	
	/**
	 * Updating brand_name, category_name, size_name in Db can be little heavy-operation 
	 * due to update anomaly and de-normalized data (Pre-joinned product table).
	 * (As customer desires data refresh after two hours)
	 */
	
	/**
	 * Price and Available count are considered as String
	 * Consider the product can be scalable for other regions as well.
	 */
}
