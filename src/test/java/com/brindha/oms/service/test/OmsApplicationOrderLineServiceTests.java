package com.brindha.oms.service.test;

import com.brindha.oms.model.Customer;
import com.brindha.oms.model.OrderLine;
import com.brindha.oms.repository.OmsOrderLineRepository;
import com.brindha.oms.service.OmsOrderLineService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest

class OmsApplicationOrderLineServiceTests {

    private OrderLine orderLine;
    @Autowired
    private OmsOrderLineService omsOrderLineService;
    @MockBean
    private OmsOrderLineRepository omsOrderLineRepository;

    @Test
    public void getOrderLineTest() {
        when(omsOrderLineRepository.findAll()).thenReturn(Stream
                .of(new OrderLine(2,4, 2),
                        new OrderLine(3,4, 1)).collect(Collectors.toList()));
        assertEquals(2, omsOrderLineService.getOrderLine().size());

    }

    @Test
    public void createOrderLineTest() {
        OrderLine orderLine = new OrderLine(2,4, 2);

        when(omsOrderLineRepository.save(orderLine))
                .thenReturn(orderLine);
        assertEquals(orderLine, omsOrderLineService.createOrderLine(orderLine));
    }


}
