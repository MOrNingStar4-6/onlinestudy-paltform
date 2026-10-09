package com.donghan.studyhub.repository;

import com.donghan.studyhub.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
