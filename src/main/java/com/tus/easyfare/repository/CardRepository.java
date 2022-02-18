package com.tus.easyfare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tus.easyfare.entity.SmartCardEntity;

public interface CardRepository extends JpaRepository<SmartCardEntity, Integer>{
	List<SmartCardEntity> findAll();
}
