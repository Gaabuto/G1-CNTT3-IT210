package com.restaurant.ss4bai0.service.bai1;


import com.restaurant.ss4bai0.repository.bai1.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    public String createOrder() {
        return "Tao don hang moi thanh cong";
    }
}
