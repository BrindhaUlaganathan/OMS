package com.brindha.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brindha.oms.model.PurchaseOrder;

@Repository
public interface OmsPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
	List<PurchaseOrder> findAll();

	
}
