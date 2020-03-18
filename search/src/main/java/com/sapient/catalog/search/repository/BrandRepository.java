package com.sapient.catalog.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.catalog.search.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

}
