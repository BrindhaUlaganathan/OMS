package com.brindha.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brindha.oms.model.Products;
import com.brindha.oms.repository.OmsProdRepository;


@Service
public class OmsProductService {
	
	@Autowired
	OmsProdRepository omsProdRepository;
	
	// CREATE uPC,prodDescription,unitPrice,unit,quantity
    public Products createProduct(Products prod) {

        return omsProdRepository.save(prod);
    }

    // READ
    public List<Products> getProducts() {

        return omsProdRepository.findAll();
    }

    // DELETE
    public void deleteProducts(int uPC) {

        omsProdRepository.deleteById(uPC);
    }
    
    // UPDATE
    public Products updateProducts(int uPC, Products prodDetails) {
    		Products prod = omsProdRepository.findById(uPC);
            prod.setProdDescription(prodDetails.getProdDescription());
            prod.setUnitPrice(prodDetails.getUnitPrice());
            prod.setUnit(prodDetails.getUnit());
            prod.setQuantity(prodDetails.getQuantity());
            
            return omsProdRepository.save(prod);                                
    }
	public String findById(int uPC) {
		Products prod = omsProdRepository.findById(uPC);
		return prod.getProdDescription();
	}
}