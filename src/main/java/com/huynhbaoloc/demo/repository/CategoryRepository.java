package com.huynhbaoloc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huynhbaoloc.demo.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
