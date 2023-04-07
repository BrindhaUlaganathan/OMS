package com.brindha.oms.controller;

import com.brindha.oms.model.OrderLine;
import com.brindha.oms.service.OmsOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class OmsOrderLineController {
    @Autowired
    OmsOrderLineService omsOrderLineService;

    @RequestMapping(value="/orderline", method= {RequestMethod.POST})

    public OrderLine createOrderLine(@RequestBody OrderLine ol) {
        return omsOrderLineService.createOrderLine(ol);
    }

    @RequestMapping(value="/orderline", method=RequestMethod.GET)
    public List<OrderLine> readOrderLine() {
        return
                omsOrderLineService.getOrderLine();
    }


}
