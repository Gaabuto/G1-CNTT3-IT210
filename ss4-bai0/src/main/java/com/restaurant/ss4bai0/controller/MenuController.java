package com.restaurant.ss4bai0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


public class MenuController {
    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(
            @RequestParam(value = "category", required = false, defaultValue = "cat") String category) {

        return "Menu loai mon an: " + category;
    }
}
