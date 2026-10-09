package com.donghan.studyhub.controller;

import com.donghan.studyhub.entity.Course;
import com.donghan.studyhub.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> list(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword) {
        return courseService.listCourses(category, keyword);
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable String id) {
        return courseService.getCourse(id);
    }
}
