package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofda.entity.FoodCartEntity;

@Repository
public interface ICartRepository extends JpaRepository<FoodCartEntity, Long> {


}