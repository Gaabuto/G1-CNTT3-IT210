package com.restaurant.ss5bt.controller;

import com.restaurant.ss5bt.common.Dish;
import com.restaurant.ss5bt.service.bai2.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public String showDishList(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "dish-list";
    }

    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable String id, Model model) {
        Dish dish = dishService.findById(id);

        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}

