package com.restaurant.ss4bai0.controller;

import com.restaurant.ss4bai0.service.bai1.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class LegacyController {
    @Controller
    @RequestMapping("com.restaurant.ss4bai0")

        private final OrderService orderService;

        @Autowired
        public LegacyController(OrderService orderService) {
            this.orderService = orderService;
        }

        @GetMapping
        @ResponseBody
        public String getAllOrders() {
            return orderService.getAllOrders();
        }

        @GetMapping("/{id}")
        @ResponseBody
        public String getOrderById(@PathVariable Long id) {
            return orderService.getOrderById(id);
        }

        @PostMapping
        @ResponseBody
        public String createOrder() {
            return orderService.createOrder();
        }
}
