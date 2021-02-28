package com.huynhbaoloc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huynhbaoloc.demo.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
