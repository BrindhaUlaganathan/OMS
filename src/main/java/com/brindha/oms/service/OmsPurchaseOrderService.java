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
    public PurchaseOrder createPurchaseOrder(PurchaseOrder prod) {
        return omsPurchaseOrderRepository.save(prod);
    }

    // READ
    public List<PurchaseOrder> getPurchaseOrder() {
        return omsPurchaseOrderRepository.findAll();
    }

//    // DELETE
//    public void deletePurchaseOrder(int orderId) {
//    	omsPurchaseOrderRepository.deleteById(orderId);
//    }
//    
//    // UPDATE
//    public PurchaseOrder updatePurchaseOrder(int orderId, PurchaseOrder poDetails) {
//    		PurchaseOrder po = omsPurchaseOrderRepository.findById(orderId).get();
//            po.setCustomerNo(poDetails.getCustomerNo());
//            po.setOrderDate(poDetails.getOrderDate());                      
//            return omsPurchaseOrderRepository.save(po);                                
//    }
//	
//	
	
}


