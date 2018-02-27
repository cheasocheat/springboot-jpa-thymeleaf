package com.glf.test.glftest.service;

import com.glf.test.glftest.domain.Order;

public interface OrderService {
    double calculatePayment(double amount);
    boolean saveOrder(Order order);
}
