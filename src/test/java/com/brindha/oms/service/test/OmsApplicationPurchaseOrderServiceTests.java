package com.brindha.oms.service.test;

import com.brindha.oms.model.PurchaseOrder;
import com.brindha.oms.repository.OmsPurchaseOrderRepository;
import com.brindha.oms.service.OmsPurchaseOrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class OmsApplicationPurchaseOrderServiceTests {

    private PurchaseOrder purchaseOrder;

    @Autowired
    private OmsPurchaseOrderService omsPurchaseOrderService;
    @MockBean
    private OmsPurchaseOrderRepository omsPurchaseOrderRepository;

    @Test
    public void getPurchaseOrderTest() {

        when(omsPurchaseOrderRepository.findAll()).thenReturn(Stream
                .of(new PurchaseOrder(103,new Date(2020-07-11)),
                        new PurchaseOrder(104,new Date(2020-07-03))).collect(Collectors.toList()));
        assertEquals(2, omsPurchaseOrderService.getPurchaseOrder().size());

    }

    @Test
    public void createPurchaseOrderTest() {
        PurchaseOrder purchaseOrder = new PurchaseOrder(103,new Date(2020-07-11));

        when(omsPurchaseOrderRepository.save(purchaseOrder))
                .thenReturn(purchaseOrder);
        assertEquals(purchaseOrder, omsPurchaseOrderService.createPurchaseOrder(purchaseOrder));
    }
}
