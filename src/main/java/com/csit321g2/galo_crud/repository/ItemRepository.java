package com.csit321g2.galo_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csit321g2.galo_crud.entity.ItemEntity;

@Repository 
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    
}
