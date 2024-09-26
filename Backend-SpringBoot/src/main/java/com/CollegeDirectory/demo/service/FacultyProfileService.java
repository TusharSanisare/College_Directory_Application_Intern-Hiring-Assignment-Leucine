package com.CollegeDirectory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeDirectory.demo.model.FacultyProfile;
import com.CollegeDirectory.demo.repository.FacultyProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyProfileService {

  @Autowired
  private FacultyProfileRepository facultyProfileRepository;

  public List<FacultyProfile> findAll() {
    return facultyProfileRepository.findAll();
  }

  public Optional<FacultyProfile> findById(Long id) {
    return facultyProfileRepository.findById(id);
  }

  public FacultyProfile save(FacultyProfile facultyProfile) {
    return facultyProfileRepository.save(facultyProfile);
  }

  public void delete(Long id) {
    facultyProfileRepository.deleteById(id);
  }
}
