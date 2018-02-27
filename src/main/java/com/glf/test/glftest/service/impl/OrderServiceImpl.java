package com.glf.test.glftest.service.impl;

import com.glf.test.glftest.domain.Order;
import com.glf.test.glftest.repository.OrderRepository;
import com.glf.test.glftest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    //Currency is Baht
    public double calculatePayment(double amount) {
        return amount > 2000 ? amount * 5 / 100 : amount;
    }

    @Override
    public boolean saveOrder(Order order) {
        repository.save(order);
        return order.getId() > 0 ? true : false;
    }
}
