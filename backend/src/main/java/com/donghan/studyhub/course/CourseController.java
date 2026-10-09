package com.donghan.studyhub.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Course> list(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword) {
        return repository.findAll().stream()
                .filter(course -> category == null || category.isBlank()
                        || "全部".equals(category) || course.getCategory().equals(category))
                .filter(course -> keyword == null || keyword.isBlank() || matches(course, keyword))
                .toList();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable String id) {
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
