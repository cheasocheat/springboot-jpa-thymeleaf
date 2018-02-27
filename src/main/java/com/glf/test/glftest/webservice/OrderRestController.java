package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.domain.Order;
import com.glf.test.glftest.service.OperationService;
import com.glf.test.glftest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OperationService operationService;

    @PostMapping(value = "/order")
    public ResponseEntity<Void> processOrder(@RequestBody Order order) {
        if (order != null) {
            double totalAmount = orderService.calculatePayment(order.getAmount());
            order.setTotalAmount(totalAmount);
            boolean success = orderService.saveOrder(order);
            if (success) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/operation_order")
    public ResponseEntity<Void> processOrderWithOperation(@RequestBody Order order, @RequestParam("order_id") Long operationId) {
        if (order != null) {
            Operation operation = operationService.findById(operationId);
            if(operation != null){
                if(operation.getPrice() > 1000){
                    order.setTaxExtension(true);
                    order.setOperationId(operationId);
                    orderService.saveOrder(order);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
