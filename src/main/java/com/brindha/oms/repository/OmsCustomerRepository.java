package com.brindha.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brindha.oms.model.Customer;



@Repository
public interface OmsCustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findAll();

	//Customer findOne(int customerId);

	Customer findById(int customerNo);	
   
	
	
	

}
