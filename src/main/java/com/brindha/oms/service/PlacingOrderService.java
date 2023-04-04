package com.brindha.oms.service;



import com.brindha.oms.model.OrderAcknowledgement;
import com.brindha.oms.model.PlacingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.brindha.oms.model.Customer;
import com.brindha.oms.model.OrderLine;
import com.brindha.oms.model.Products;
import com.brindha.oms.model.PurchaseOrder;

import com.brindha.oms.repository.OmsOrderLineRepository;

@Service
public class PlacingOrderService {
	
	@Autowired
	private OmsOrderLineRepository omsOrderLineRepository;
	@Autowired
	private OmsPurchaseOrderService omsPurchaseOrderservice;
	@Autowired
	private OmsCustomerService omsCustomerservice;
	@Autowired
	private OmsProductService omsProductservice;
	@Autowired
	private OmsOrderLineService omsOrderLineService;
	
	public OrderAcknowledgement placeOrder(@RequestBody PlacingOrder placingOrder) {
		
			Customer custPlacingOrder = omsCustomerservice
											.findById(placingOrder.getcustomerNo());
			
		    Products orderedProduct = omsProductservice
											.findById(placingOrder.getuPC());

			PurchaseOrder po= new PurchaseOrder(placingOrder.getcustomerNo());
			omsPurchaseOrderservice.createPurchaseOrder(po);

			OrderLine ol= new OrderLine(placingOrder.getuPC(),placingOrder.getNoOfItems(), po.getOrderId());
			omsOrderLineService.createOrderLine(ol);

			
			
			return new OrderAcknowledgement(custPlacingOrder.getName(),
											po.getOrderId(),
											po.getOrderDate(),
											orderedProduct.getProdDescription(),
											placingOrder.getNoOfItems(),
											ol.getOrderItemNumber());
			
		
	}
}	