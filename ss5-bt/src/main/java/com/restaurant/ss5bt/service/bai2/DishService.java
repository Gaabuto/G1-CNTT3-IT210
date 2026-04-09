package com.restaurant.ss5bt.service.bai2;


import com.restaurant.ss5bt.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    public List<Dish> getAllDishes() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish("C001", "Phở bò", 50000, true));
        list.add(new Dish("C002", "Bún chả", 45000, false));
        list.add(new Dish("C003", "Cơm tấm", 40000, true));

        return list;


    }
    public Dish findById(String id) {
        return list.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
