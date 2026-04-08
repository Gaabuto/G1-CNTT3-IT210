package com.restaurant.ss4bai0.service;


import com.restaurant.repository.AppRepository;
import com.restaurant.ss4bai0.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AppService {
    @Service
    public class FoodService {

        @Autowired
        private com.restaurant.ss4bai0.repository.AppRepository repository;

        public String getFood() {
            return repository.getApp();
        }
    }
}
