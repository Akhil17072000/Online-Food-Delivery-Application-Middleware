package com.cg.ofda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofda.entity.LoginEntity;

@Repository
public interface ILoginRepository  extends JpaRepository<LoginEntity, Long> {

}
