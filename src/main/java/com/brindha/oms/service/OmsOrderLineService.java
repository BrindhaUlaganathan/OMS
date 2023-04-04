package com.brindha.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brindha.oms.model.OrderLine;
import com.brindha.oms.repository.OmsOrderLineRepository;


@Service
public class OmsOrderLineService {
	@Autowired
	OmsOrderLineRepository omsOrderLineRepository;
	
	// CREATE 
    public OrderLine createOrderLine(OrderLine ol) {

        return omsOrderLineRepository.save(ol);
    }

    // READ
    public List<OrderLine> getOrderLine() {

        return omsOrderLineRepository.findAll();
    }

	
}