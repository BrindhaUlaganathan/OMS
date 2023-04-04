package com.brindha.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.brindha.oms.model.PurchaseOrder;
import com.brindha.oms.repository.OmsPurchaseOrderRepository;

@Service
public class OmsPurchaseOrderService {
	@Autowired
	OmsPurchaseOrderRepository omsPurchaseOrderRepository;
	
	// CREATE 
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po){

       return omsPurchaseOrderRepository.save(po);
    }

    // READ
    public List<PurchaseOrder> getPurchaseOrder() {

        return omsPurchaseOrderRepository.findAll();
    }


	
}


