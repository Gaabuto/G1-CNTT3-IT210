package com.restaurant.ss4bai0.controller;

import com.restaurant.ss4bai0.service.AppService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AppController {
    private AppService AppService;


    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("apps", appService.getProjects());
        return "projects/list-app";
    }

}
