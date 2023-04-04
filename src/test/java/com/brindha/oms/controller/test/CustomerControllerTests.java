package com.brindha.oms.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.Mockito.when;

import com.brindha.oms.controller.OmsCustomerController;
import com.brindha.oms.model.Customer;
import com.brindha.oms.service.OmsCustomerService;
import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.junit.jupiter.MockitoExtension;
        import org.springframework.http.ResponseEntity;
        import org.springframework.mock.web.MockHttpServletRequest;
        import org.springframework.web.context.request.RequestContextHolder;
        import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTests {

    @InjectMocks
    OmsCustomerController omsCustomerController;

    @Mock
    OmsCustomerService omsCustomerService;

    @Test
    public void testCreateCustomer()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Customer customer = new Customer( 1,"Lisa", "4664514634646");
        when(omsCustomerService.createCustomer(any(Customer.class))).thenReturn(customer);
        ResponseEntity<Object> responseEntity = omsCustomerController.createCustomer(customer);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }



   
}