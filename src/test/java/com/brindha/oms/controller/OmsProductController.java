package com.brindha.oms.controller;

import com.brindha.oms.model.Products;
import com.brindha.oms.service.OmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OmsProductController {
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

}
