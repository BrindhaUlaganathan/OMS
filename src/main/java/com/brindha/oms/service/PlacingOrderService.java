package com.brindha.oms.service;



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
	
	public OrderAcknowledgement placeorder(@RequestBody PlacingOrder placingorderrequest) {
		
		
			Customer custPlacingOrder = omsCustomerservice
											.findById(placingorderrequest.getcustomerNo());
			
		    Products orderedProduct = omsProductservice
											.findById(placingorderrequest.getuPC());
		    

			PurchaseOrder po= new PurchaseOrder(placingorderrequest.getcustomerNo());	
			PurchaseOrder order= omsPurchaseOrderservice.createPurchaseOrder(po);
			    
			//create  order line  using the NoOfItems 
			OrderLine ol= new OrderLine(placingorderrequest.getuPC(),placingorderrequest.getNoOfItems(),order.getOrderId());
			omsOrderLineRepository.save(ol);		    
			
			
			return new OrderAcknowledgement(custPlacingOrder.getName(),
											po.getOrderId(),
											order.getOrderDate(),
											orderedProduct.getProdDescription(),
											ol.getNumberOfItems(),
											ol.getOrderItemNumber());
			
		
	}
}	