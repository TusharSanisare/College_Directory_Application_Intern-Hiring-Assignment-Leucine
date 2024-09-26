package com.CollegeDirectory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeDirectory.demo.model.StudentProfile;
import com.CollegeDirectory.demo.repository.StudentProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileService {

  @Autowired
  private StudentProfileRepository studentProfileRepository;

  public List<StudentProfile> findAll() {
    return studentProfileRepository.findAll();
  }

  public Optional<StudentProfile> findById(Long id) {
    return studentProfileRepository.findById(id);
  }

  public StudentProfile save(StudentProfile studentProfile) {
    return studentProfileRepository.save(studentProfile);
  }

  public void delete(Long id) {
    studentProfileRepository.deleteById(id);
  }
}
