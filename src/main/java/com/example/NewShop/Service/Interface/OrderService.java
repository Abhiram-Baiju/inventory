package com.example.NewShop.Service.Interface;

import com.example.NewShop.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(long id);
    Order createOrder(Order order);
    Order updateOrder(long id, Order order);
    void deleteOrder(long id);
}
