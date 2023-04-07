package com.brindha.oms.service;

import java.util.List;
import java.util.Optional;

import com.brindha.oms.model.OrderLine;
import com.brindha.oms.repository.OmsOrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.brindha.oms.model.PurchaseOrder;
import com.brindha.oms.repository.OmsPurchaseOrderRepository;

@Service
public class OmsPurchaseOrderService {
	@Autowired
	OmsPurchaseOrderRepository omsPurchaseOrderRepository;
    @Autowired
    OmsOrderLineRepository omsOrderLineRepository;
    @Autowired
    OmsProductService omsProductService;

        // CREATE
        public PurchaseOrder createPurchaseOrder(PurchaseOrder order) {
            PurchaseOrder po = omsPurchaseOrderRepository.save(order);
            OrderLine ol= new OrderLine(order.getOrderId());
            String prodName = omsProductService.findById(ol.getuPC());
            omsOrderLineRepository.save(ol);
            return po;
        }




    // READ
    public List<PurchaseOrder> getPurchaseOrder() {

        return omsPurchaseOrderRepository.findAll();
    }

    public Optional<PurchaseOrder> getPurchaseOrderById(int orderId) {

        return omsPurchaseOrderRepository.findById(orderId);
    }




}


