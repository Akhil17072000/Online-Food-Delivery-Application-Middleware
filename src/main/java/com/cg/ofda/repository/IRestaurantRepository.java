package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofda.entity.RestaurantEntity;

@Repository
public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long>{


}