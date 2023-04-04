package com.brindha.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brindha.oms.model.Customer;
import com.brindha.oms.service.OmsCustomerService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//1
import java.net.URI;

@RestController
@RequestMapping("/api")
public class OmsCustomerController {	
	
	@Autowired
	OmsCustomerService omsCustomerService;
    
    @RequestMapping(value="/customer", method= {RequestMethod.POST})

	public ResponseEntity<Object> createCustomer(@RequestBody Customer cust) {

		omsCustomerService.createCustomer(cust);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{customerNo}")
				.buildAndExpand(cust.getCustomerNo())
				.toUri();

		return ResponseEntity.created(location).build();
	}

//    public Customer createCustomer(@RequestBody Customer cust) {
//
//		return omsCustomerService.createCustomer(cust);
//    }
   
    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public List<Customer> readCustomers() {

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

}