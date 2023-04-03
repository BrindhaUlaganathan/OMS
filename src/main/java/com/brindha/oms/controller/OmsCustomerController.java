package com.brindha.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brindha.oms.service.OrderAcknowledgement;
import com.brindha.oms.service.PlacingOrder;
import com.brindha.oms.model.Customer;
import com.brindha.oms.model.OrderLine;
import com.brindha.oms.model.Products;
import com.brindha.oms.model.PurchaseOrder;
import com.brindha.oms.service.OmsCustomerService;
import com.brindha.oms.service.OmsOrderLineService;
import com.brindha.oms.service.OmsProductService;
import com.brindha.oms.service.OmsPurchaseOrderService;
import com.brindha.oms.service.PlacingOrderService;


@RestController
@RequestMapping("/api")
public class OmsCustomerController {	
	
	@Autowired
	OmsCustomerService omsCustomerService;
	
	@Autowired
	private PlacingOrderService poservice;
	

	@RequestMapping(value="/placeorder", method= {RequestMethod.POST})
	public OrderAcknowledgement placeorder(@RequestBody PlacingOrder placingorderrequest) {
		return  poservice.placeorder(placingorderrequest);		
	}
    
    @RequestMapping(value="/customer", method= {RequestMethod.POST})
    public Customer createEmployee(@RequestBody Customer cust) {
		return omsCustomerService.createCustomer(cust);
    }
   
    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public List<Customer> readEmployees() {
		return omsCustomerService.getCustomers();
    }

	@RequestMapping(value="/customer/{customerNo}", method=RequestMethod.PUT)
	public Customer readCustomer(@PathVariable(value = "customerNo") int id, @RequestBody Customer customerDetails) {
	   return omsCustomerService.updateCustomer(id, customerDetails);
	 }

	@RequestMapping(value="/customer/{customerNo}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable(value = "customerNo") int id) {
		omsCustomerService.deleteCustomer(id);
	}
	
	@Autowired
	OmsOrderLineService omsOrderLineService;
     
    @RequestMapping(value="/orderline", method= {RequestMethod.POST})
    
    public OrderLine createOrderLineService(@RequestBody OrderLine ol) {
        return omsOrderLineService.createOrderLine(ol);
    }
   
    @RequestMapping(value="/orderline", method=RequestMethod.GET)
    public List<OrderLine> readOrderLineService() {
		return omsOrderLineService.getOrderLine();
    }


    @Autowired
	OmsProductService omsProductService;
    
    @RequestMapping(value="/products", method= {RequestMethod.POST})    
    public Products createProduct(@RequestBody Products prod) {
		return omsProductService.createProduct(prod);
    }
   
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Products> getProducts() {
		return omsProductService.getProducts();
    }

	@RequestMapping(value="/products/{uPC}", method=RequestMethod.PUT)
	public Products readProducts(@PathVariable(value = "uPC") int id, @RequestBody Products prodDetails) {
	   return omsProductService.updateProducts(id, prodDetails);
	 }

	@RequestMapping(value="/products/{uPC}", method=RequestMethod.DELETE)
	public void deleteProducts(@PathVariable(value = "uPC") int id) {
		omsProductService.deleteProducts(id);
	}
	
	
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