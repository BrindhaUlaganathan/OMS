package com.brindha.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brindha.oms.model.Customer;
import com.brindha.oms.repository.OmsCustomerRepository;


@Service
public class OmsCustomerService{// implements IcustomerService {
	
	@Autowired
	OmsCustomerRepository omsCustomerRepository;
	
	//Customer c1 = new Customer("Kieren","7654387253");
	
	// CREATE 
    public Customer createCustomer(Customer cust) {
        return omsCustomerRepository.save(cust);
    }
       // READ
    public List<Customer> getCustomers() {

        return omsCustomerRepository.findAll();
    }
    //Get a customer by Id
   
    public Customer findById(int customerNo) {
        return omsCustomerRepository.findById(customerNo);
    }
    // DELETE
    public void deleteCustomer(int customerId) {
    	omsCustomerRepository.deleteById(customerId);
    }
    
    // UPDATE
    public Customer updateCustomer(int customerId, Customer customerDetails) {
    		Customer cust = omsCustomerRepository.findById(customerId);
            cust.setName(customerDetails.getName());
            cust.setMobile(customerDetails.getMobile());          
            return omsCustomerRepository.save(cust);                                
    }

}