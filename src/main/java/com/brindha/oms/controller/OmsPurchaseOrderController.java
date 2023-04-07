package com.brindha.oms.controller;

import com.brindha.oms.model.PurchaseOrder;
import com.brindha.oms.service.OmsPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping(value="/purchaseorder/{orderId}", method=RequestMethod.GET)
    public Optional<PurchaseOrder> getPurchaseOrderById(@PathVariable int orderId) {

        return omsPurchaseOrderService.getPurchaseOrderById(orderId);
    }


}
