package com.example.NewShop.Service.Impliments;

import com.example.NewShop.Exception.ResourceNotFoundException;
import com.example.NewShop.model.Order;
import com.example.NewShop.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepo orderRepo;

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepo.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(Long OrderId,Order orderDetails) {
        Order order=orderRepo.findById(OrderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderDetails));
        order.setUserId(orderDetails.getUserId());
        order.setOrderDate(orderDetails.getOrderDate());
        order.setStatus(orderDetails.getStatus());
        order.setTotalAmount(orderDetails.getTotalAmount());
        return orderRepo.save(order);
    }

    public void deleteOrder(Long orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
        orderRepo.delete(order);
    }


    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }
}

