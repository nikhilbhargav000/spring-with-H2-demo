package com.sapient.catalog.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.catalog.search.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	public List<ProductEntity> findByProductSku(String productSku);

	
	public List<ProductEntity> findByBrandIdInAndSizeIdInAndProductSkuIn(List<Long> brandIds,
			List<Long> productSizeIds, List<String> productSkus);

	
	public List<ProductEntity> findByBrandIdInAndSizeIdIn(List<Long> brandIds, List<Long> productSizeIds);

	public List<ProductEntity> findByBrandIdInAndProductSkuIn(List<Long> brandIds, List<String> productSkus);

	public List<ProductEntity> findBySizeIdInAndProductSkuIn(List<Long> productSizeIds, List<String> productSkus);
	
	
	public List<ProductEntity> findByBrandIdIn(List<Long> brandIds);

	public List<ProductEntity> findBySizeIdIn(List<Long> productSizeIds);
	
	public List<ProductEntity> findByProductSkuIn(List<String> productSkus);
	
	
}
