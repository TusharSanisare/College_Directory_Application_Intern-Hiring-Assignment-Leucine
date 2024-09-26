package com.CollegeDirectory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.model.StudentProfile;
import com.CollegeDirectory.demo.service.StudentProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/students")
public class StudentProfileController {

  @Autowired
  private StudentProfileService studentProfileService;

  @GetMapping
  public List<StudentProfile> getAllStudents() {
    return studentProfileService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
    Optional<StudentProfile> studentProfile = studentProfileService.findById(id);
    return studentProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public StudentProfile createStudent(@RequestBody StudentProfile studentProfile) {
    return studentProfileService.save(studentProfile);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentProfile> updateStudent(@PathVariable Long id,
      @RequestBody StudentProfile studentProfile) {
    studentProfile.setUserId(id);
    StudentProfile updatedStudentProfile = studentProfileService.save(studentProfile);
    return ResponseEntity.ok(updatedStudentProfile);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    studentProfileService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
