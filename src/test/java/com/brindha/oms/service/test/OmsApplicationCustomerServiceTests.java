package com.brindha.oms.service.test;

import com.brindha.oms.model.Customer;
import com.brindha.oms.repository.OmsCustomerRepository;
import lombok.Builder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.brindha.oms.service.OmsCustomerService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class OmsApplicationCustomerServiceTests {
    private Customer customer;
    @Autowired
    private OmsCustomerService omsCustomerService;
    @MockBean
    private OmsCustomerRepository omsCustomerRepository;

    @Test
    public void getCustomersTest() {
        when(omsCustomerRepository.findAll()).thenReturn(Stream
                .of(new Customer("Johny", "7852369426"),
                        new Customer("Eleven", "8962314562")).collect(Collectors.toList()));
        assertEquals(2, omsCustomerService.getCustomers().size());

    }

    @Test
    public void addCustomersTest() {
        Customer customer = new Customer("Eleven", "8962314562");

        when(omsCustomerRepository.save(customer))
                .thenReturn(customer);
        assertEquals(customer, omsCustomerService.createCustomer(customer));

    }

    @Before
    @Builder
    public void setup() {

        Customer customer = Customer.builder()
                .customerNo(10)
                .name("Ramesh")
                .mobile("789652341")
                .build();
    }

    @Test
    public void deleteCustomerTest() {
        int customerNo = 10;
        willDoNothing().given(omsCustomerRepository).deleteById(customerNo);
        omsCustomerService.deleteCustomer(customerNo);
        verify(omsCustomerRepository, times(1)).deleteById(customerNo);
    }

}