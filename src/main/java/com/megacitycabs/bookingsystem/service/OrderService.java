package com.megacitycabs.bookingsystem.service;

import com.megacitycabs.bookingsystem.model.Order;
import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomer(Long customerId);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}