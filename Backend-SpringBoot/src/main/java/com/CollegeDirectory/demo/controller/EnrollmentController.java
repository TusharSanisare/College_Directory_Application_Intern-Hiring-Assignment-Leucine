package com.CollegeDirectory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.model.Enrollment;
import com.CollegeDirectory.demo.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

  @Autowired
  private EnrollmentService enrollmentService;

  @GetMapping
  public List<Enrollment> getAllEnrollments() {
    return enrollmentService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
    return enrollmentService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
    return enrollmentService.save(enrollment);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
    enrollment.setId(id);
    return ResponseEntity.ok(enrollmentService.save(enrollment));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
    enrollmentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
