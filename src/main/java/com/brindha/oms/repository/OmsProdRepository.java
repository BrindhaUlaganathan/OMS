package com.brindha.oms.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.brindha.oms.model.Products;

@Repository
public interface OmsProdRepository extends JpaRepository<Products, Integer> {
	List<Products> findAll();
	Products findById(int uPC); 
}
