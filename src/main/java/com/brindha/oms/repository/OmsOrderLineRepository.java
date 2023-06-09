package com.brindha.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brindha.oms.model.OrderLine;

@Repository
public interface OmsOrderLineRepository extends JpaRepository<OrderLine, Integer> {
	List<OrderLine> findAll(); 
}
