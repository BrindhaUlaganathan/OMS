package com.brindha.oms;

import com.brindha.oms.model.Products;
import com.brindha.oms.repository.OmsProdRepository;
import com.brindha.oms.service.OmsProductService;
import lombok.Builder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class OmsApplicationProductTests {
    private Products Products;
    @Autowired
    private OmsProductService omsProductService;
    @MockBean
    private OmsProdRepository omsProdRepository;

    @Test
    public void getProductsTest() {
        when(omsProductService.getProducts()).thenReturn(Stream
                .of(new Products(2,"Fish", 26,"Kg",20),
                        new Products(3,"Onion", 10,"Kg",15))
                .collect(Collectors.toList()));
        assertEquals(2, omsProductService.getProducts().size());

    }
    @Test
    public void addProductsTest() {
        Products products = new Products("Water", 10,"Litre",15);

        when(omsProdRepository.save(products))
                .thenReturn(Products);
        assertEquals(Products, omsProductService.createProduct(products));

    }
    @Before
    @Builder
    public void setup() {

        Products products = new Products(10,"Greens",20,"Kg",4);

    }

    @Test
    public void deleteProductsTest() {
        int uPC = 10;
        willDoNothing().given(omsProdRepository).deleteById(uPC);
        omsProductService.deleteProducts(uPC);
        verify(omsProdRepository, times(1)).deleteById(uPC);
    }



}