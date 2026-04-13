package com.restaurant.session06_btth.service;

import com.restaurant.session06_btth.model.entity.Course;
import com.restaurant.session06_btth.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> filterCourses(String level, double maxPrice) {
        return repo.findAll().stream()
                .filter(c -> level.equals("All") || c.getLevel().equals(level))
                .filter(c -> c.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public Course getByCode(String code) {
        return repo.findByCode(code);
    }

    public void updateCourse(Course updatedCourse) {
        Course existing = repo.findByCode(updatedCourse.getCode());
        if (existing != null) {
            existing.setPrice(updatedCourse.getPrice());
            existing.setStartDate(updatedCourse.getStartDate());
        }
    }

    public String deleteCourse(String code) {
        Course course = repo.findByCode(code);
        if (course != null) {
            if (course.getStudentCount() > 0) {
                return "Không thể hủy khóa học đã có học viên đăng ký!";
            }
            repo.remove(code);
            return "SUCCESS";
        }
        return "Không tìm thấy khóa học!";
    }
}
