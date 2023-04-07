package com.brindha.oms.controller;

import com.brindha.oms.model.OrderAcknowledgement;
import com.brindha.oms.model.PlacingOrder;
import com.brindha.oms.service.PlacingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OmsPlacingOrderController {
    @Autowired
    private PlacingOrderService poservice;


//    @RequestMapping(value="/placeorder", method= {RequestMethod.POST})
//    public OrderAcknowledgement placeorder(@RequestBody PlacingOrder placingorderrequest) {
//        return  poservice.placeOrder(placingorderrequest);
//    }
}
