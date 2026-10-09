package com.donghan.studyhub.service;

import com.donghan.studyhub.entity.Course;
import com.donghan.studyhub.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> listCourses(String category, String keyword) {
        return repository.findAll().stream()
                .filter(course -> category == null || category.isBlank()
                        || "全部".equals(category) || course.getCategory().equals(category))
                .filter(course -> keyword == null || keyword.isBlank() || matches(course, keyword))
                .toList();
    }

    public Course getCourse(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "课程不存在"));
    }

    private boolean matches(Course course, String keyword) {
        String normalized = keyword.trim().toLowerCase();
        return course.getTitle().toLowerCase().contains(normalized)
                || course.getDescription().toLowerCase().contains(normalized)
                || course.getTags().stream().anyMatch(tag -> tag.toLowerCase().contains(normalized));
    }
}
