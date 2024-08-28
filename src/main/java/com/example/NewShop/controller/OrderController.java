package com.example.NewShop.controller;
import com.example.NewShop.Exception.ResourceNotFoundException;
import com.example.NewShop.Service.Impliments.OrderServiceImpl;
import com.example.NewShop.model.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

@RestController
@Validated
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @PostMapping(path = "/orders")
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderServiceImpl.createOrder(order);
    }

    @GetMapping(path = "/orders")
    public List<Order> getAllOrders() {
        return orderServiceImpl.getAllOrders();
    }

    @GetMapping(path = "/orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "orderId") Long orderId) {
        Optional<Order> order = orderServiceImpl.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping(path = "/orders/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "orderId") Long orderId, @RequestBody Order orderDetails) {
        try {
            Order updatedOrder = orderServiceImpl.updateOrder(orderId, orderDetails);
            return ResponseEntity.ok(updatedOrder);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(value = "orderId") Long orderId) {
        try {
            orderServiceImpl.deleteOrder(orderId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
