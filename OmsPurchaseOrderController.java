package com.brindha.oms.controller;

import com.brindha.oms.model.PurchaseOrder;
import com.brindha.oms.service.OmsPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class OmsPurchaseOrderController {

    @Autowired
    OmsPurchaseOrderService omsPurchaseOrderService;

    @RequestMapping(value="/purchaseorder", method= {RequestMethod.POST})
    public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder po) {
        return omsPurchaseOrderService.createPurchaseOrder(po);
    }

    @RequestMapping(value="/purchaseorder", method=RequestMethod.GET)
    public List<PurchaseOrder> readPurchaseOrder() {
        return omsPurchaseOrderService.getPurchaseOrder();
    }
}
