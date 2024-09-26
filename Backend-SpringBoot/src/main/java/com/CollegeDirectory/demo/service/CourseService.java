package com.CollegeDirectory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeDirectory.demo.model.Course;
import com.CollegeDirectory.demo.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  public Optional<Course> findById(Long id) {
    return courseRepository.findById(id);
  }

  public Course save(Course course) {
    return courseRepository.save(course);
  }

  public void delete(Long id) {
    courseRepository.deleteById(id);
  }
}
