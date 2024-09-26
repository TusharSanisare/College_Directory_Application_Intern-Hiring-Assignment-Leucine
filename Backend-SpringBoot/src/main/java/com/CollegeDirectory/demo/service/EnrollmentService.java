package com.CollegeDirectory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeDirectory.demo.model.Enrollment;
import com.CollegeDirectory.demo.repository.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

  @Autowired
  private EnrollmentRepository enrollmentRepository;

  public List<Enrollment> findAll() {
    return enrollmentRepository.findAll();
  }

  public Optional<Enrollment> findById(Long id) {
    return enrollmentRepository.findById(id);
  }

  public Enrollment save(Enrollment enrollment) {
    return enrollmentRepository.save(enrollment);
  }

  public void delete(Long id) {
    enrollmentRepository.deleteById(id);
  }
}
