package com.sapient.catalog.search.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sapient.catalog.search.controller.ProductController;
import com.sapient.catalog.search.model.Product;
/**
 * Currently, I am uncomfortable with writing test case in spring app 
 * Writing JUnit test cases based on controller function
 * 
 * @author nikhil
 *
 */
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;

	@Test
	public void test1() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}
	
	@Test
	public void test2() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		brandIds.add("201001");
		brandIds.add("201002");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}
	
	@Test
	public void test3() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}	
	
	@Test
	public void test4() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		productSizeIds.add("151001");
		productSizeIds.add("151002");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}	
	
	@Test
	public void test5() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		productSizeIds.add("151001");
		productSizeIds.add("151002");
		
		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}
	
	@Test
	public void test6() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		productSizeIds.add("151001");
		productSizeIds.add("151002");
		
		brandIds.add("201001");
		brandIds.add("201002");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}
	
	@Test
	public void test7() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		brandIds.add("201001");
		brandIds.add("201002");
		
		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}	
	
	@Test
	public void test8() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		brandIds.add("201001");
		brandIds.add("201002");
		
		productSizeIds.add("151001");
		productSizeIds.add("151002");
		
		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.OK.value());
	}	

	@Test
	public void test9() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		brandIds.add("201001t");
		brandIds.add("201002");
		
		productSizeIds.add("151001");
		productSizeIds.add("151002");
		
		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.BAD_REQUEST.value());
	}
	@Test
	public void test10() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		brandIds.add("201002");
		
		productSizeIds.add("151001ggg");
		
		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.BAD_REQUEST.value());
	}
	@Test
	public void test11() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		productSizeIds.add("151001ggg");
		
		productSkus.add("1010101010");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void test12() {
		List<String> brandIds = new ArrayList<String>();
		List<String> productSkus = new ArrayList<String>();
		List<String> productSizeIds = new ArrayList<String>();

		brandIds.add("201002tt");
		
		productSizeIds.add("151001ggg");
		
		ResponseEntity<List<Product>> response = productController.findProduct(brandIds, productSkus, productSizeIds);
		
		Assert.assertTrue(response.getStatusCodeValue() == HttpStatus.BAD_REQUEST.value());
	}
}
