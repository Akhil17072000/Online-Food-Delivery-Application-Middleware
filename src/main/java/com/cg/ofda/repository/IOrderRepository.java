package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofda.entity.OrderDetailsEntity;


@Repository
public interface IOrderRepository  extends JpaRepository<OrderDetailsEntity, Long>{


}
