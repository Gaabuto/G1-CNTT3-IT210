package com.restaurant.session06_btth.repository;

import com.restaurant.session06_btth.model.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course("IELTS-6.5", "IELTS Master 6.5+", "Advanced", 8500000, "Đạt mục tiêu IELTS 6.5.", "Nguyễn Chung Tú", "36 buổi", "15/06/2026", 20, 20)); // Lớp đầy 20/20 -> isFull() = true
        courses.add(new Course("TOEIC-750", "TOEIC Đảm bảo 750", "Intermediate", 4500000, "Luyện đề thực chiến.", "Trần Bảo Dũng", "24 buổi", "20/06/2026", 15, 30));
        courses.add(new Course("COM-01", "Giao tiếp cơ bản", "Beginner", 3000000, "Phản xạ tiếng Anh.", "Bàng Tiến Dũng", "20 buổi", "01/07/2026", 5, 25));
        courses.add(new Course("GRAM-01", "Ngữ pháp chuyên sâu", "Advanced", 5000000, "Nắm chắc 12 thì.", "Trần Quốc Hiếu", "30 buổi", "10/07/2026", 0, 20)); // Lớp trống 0/20 -> Có thể test xóa thành công
        courses.add(new Course("PRO-01", "Phát âm chuẩn IPA", "Beginner", 2500000, "Chỉnh khẩu hình miệng.", "Đỗ Trọng Thành", "15 buổi", "05/06/2026", 10, 15));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public void remove(String code) {
        courses.removeIf(c -> c.getCode().equals(code));
    }
}
