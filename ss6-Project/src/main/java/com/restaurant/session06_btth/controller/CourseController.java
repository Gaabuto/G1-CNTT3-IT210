package com.restaurant.session06_btth.controller;

import com.restaurant.session06_btth.model.entity.Course;
import com.restaurant.session06_btth.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping("/list")
    public String listCourses(
            @RequestParam(name = "level", required = false, defaultValue = "All") String level,

            @RequestParam(name = "maxPrice", required = false, defaultValue = "100000000") Long maxPrice,

            Model model) {

        model.addAttribute("courses", service.filterCourses(level, maxPrice));
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxPrice", maxPrice);
        return "course/list";
    }

    @GetMapping("/detail/{code}")
    public String detailCourse(@PathVariable("code") String code, Model model) {
        model.addAttribute("course", service.getByCode(code));
        return "course/detail";
    }

    @GetMapping("/edit/{code}")
    public String showEditForm(@PathVariable("code") String code, Model model) {
        model.addAttribute("course", service.getByCode(code));
        return "course/edit";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute Course course, RedirectAttributes redirectAttributes) {
        service.updateCourse(course);
        redirectAttributes.addFlashAttribute("successMsg", "Cập nhật thành công khóa học: " + course.getCode());
        return "redirect:/course/list";
    }

    @PostMapping("/delete/{code}")
    public String deleteCourse(@PathVariable("code") String code, RedirectAttributes redirectAttributes) {
        String result = service.deleteCourse(code);
        if (result.equals("SUCCESS")) {
            redirectAttributes.addFlashAttribute("successMsg", "Đã xóa thành công khóa học!");
        } else {
            redirectAttributes.addFlashAttribute("errorMsg", result);
        }
        return "redirect:/course/list";
    }
}
