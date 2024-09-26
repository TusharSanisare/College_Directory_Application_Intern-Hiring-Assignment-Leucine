package com.CollegeDirectory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.model.FacultyProfile;
import com.CollegeDirectory.demo.service.FacultyProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
public class FacultyProfileController {

  @Autowired
  private FacultyProfileService facultyProfileService;

  @GetMapping
  public List<FacultyProfile> getAllFaculty() {
    return facultyProfileService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<FacultyProfile> getFacultyById(@PathVariable Long id) {
    Optional<FacultyProfile> facultyProfile = facultyProfileService.findById(id);
    return facultyProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public FacultyProfile createFaculty(@RequestBody FacultyProfile facultyProfile) {
    return facultyProfileService.save(facultyProfile);
  }

  @PutMapping("/{id}")
  public ResponseEntity<FacultyProfile> updateFaculty(@PathVariable Long id,
      @RequestBody FacultyProfile facultyProfile) {
    facultyProfile.setUserId(id);
    FacultyProfile updatedFacultyProfile = facultyProfileService.save(facultyProfile);
    return ResponseEntity.ok(updatedFacultyProfile);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
    facultyProfileService.delete(id);
    return ResponseEntity.noContent().build();
  }
}