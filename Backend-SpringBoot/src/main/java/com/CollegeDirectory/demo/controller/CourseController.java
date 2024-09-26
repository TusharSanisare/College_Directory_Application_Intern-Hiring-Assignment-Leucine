package com.CollegeDirectory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.model.Course;
import com.CollegeDirectory.demo.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @GetMapping
  public List<Course> getAllCourses() {
    return courseService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
    Optional<Course> course = courseService.findById(id);
    return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Course createCourse(@RequestBody Course course) {
    return courseService.save(course);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
    course.setId(id);
    Course updatedCourse = courseService.save(course);
    return ResponseEntity.ok(updatedCourse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
    courseService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
