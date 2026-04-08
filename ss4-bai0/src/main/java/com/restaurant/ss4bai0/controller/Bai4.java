package com.restaurant.ss4bai0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

// url -> /bai4/products?category=chay&limit=10 -> controller -> param -> model map qua key category, limit, message -> view -> /WEB-INF/views/productList


@Controller
@RequestMapping("/bai4/products")
public class Bai4 {





    @GetMapping
    public String getProducts(
            @RequestParam String category,
            @RequestParam int limit,
            ModelMap model) {

        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tìm kiếm thành công");

        return "productList";
}
}