package com.glf.test.glftest;


import com.glf.test.glftest.domain.Order;
import com.glf.test.glftest.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRestTest {

    @Autowired
    private HttpHeaders header;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Test With RestTemplate
     */

    @Test
    public void simpleOrder() {
        Order order = new Order();
        order.setAmount(2100.0);
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> requestEntity = new HttpEntity<>(order, header);
        restTemplate.exchange("http://localhost:8080/gltest/api/v1/order", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Order>() {
        });

    }

    @Test
    public void orderWithTaxExtension() {
        Order order = new Order();
        order.setAmount(2100.0);
        order.setOperationId(69l);
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> requestEntity = new HttpEntity<>(order, header);
        restTemplate.exchange("http://localhost:8080/gltest/api/v1/operation_order?order_id=" + order.getOperationId(), HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Order>() {
        });
    }
}
