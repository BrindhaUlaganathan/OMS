package com.brindha.oms.service.test;

import com.brindha.oms.model.*;
import com.brindha.oms.repository.OmsCustomerRepository;
import com.brindha.oms.repository.OmsOrderLineRepository;
import com.brindha.oms.repository.OmsProdRepository;
import com.brindha.oms.repository.OmsPurchaseOrderRepository;
import com.brindha.oms.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class OmsApplicationPlacingOrderServiceTests {


    @Autowired
    private PlacingOrderService placingOrderService;

    @Autowired
    private OmsPurchaseOrderService omsPurchaseOrderservice;
    @Autowired
    private OmsCustomerService omsCustomerservice;
    @Autowired
    private OmsProductService omsProductservice;
    @Autowired
    private OmsOrderLineService omsOrderLineService;

    @MockBean
    private OmsOrderLineRepository omsOrderLineRepository;
    @MockBean
    private OmsCustomerRepository omsCustomerRepository;
    @MockBean
    private OmsProdRepository omsProdRepository;
    @MockBean
    private OmsPurchaseOrderRepository omsPurchaseOrderRepository;

    @Test
    public void placeOrderTest() {

        PlacingOrder placingOrder = new PlacingOrder(202,2,"Egg",5);

        OrderAcknowledgement oack = new OrderAcknowledgement("John",101,
              new Date(2020-07-11),"Egg",5,105);

        when(omsCustomerservice.findById(placingOrder.getcustomerNo()))
                .thenReturn(new Customer(202,"John","78963521423"));

        when(omsProductservice.findById(placingOrder.getuPC()))
                .thenReturn(new Products(2,"Egg",20,"Nos",5));
        PurchaseOrder po = new PurchaseOrder();
        PurchaseOrder po1 = new PurchaseOrder(101,202,new Date(2020-07-11));
        when(omsPurchaseOrderservice.createPurchaseOrder(po))
                .thenReturn(po1);

        OrderLine ol = new OrderLine();
        OrderLine ol1= new OrderLine(105,2,5,101);

        when(omsOrderLineService.createOrderLine(ol))
                .thenReturn(ol1);

        when(omsOrderLineRepository.save(ol))
                .thenReturn(new OrderLine(105,2,5,101));

        System.out.println(oack.toString());
        System.out.println(placingOrderService.placeOrder(placingOrder).toString());
        assertNotEquals(oack,placingOrderService.placeOrder(placingOrder));

    }


}
