package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofda.entity.ItemEntity;

@Repository
public interface IItemRepository  extends JpaRepository<ItemEntity, Long> {


}
