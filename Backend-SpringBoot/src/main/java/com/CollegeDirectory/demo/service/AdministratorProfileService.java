package com.CollegeDirectory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeDirectory.demo.model.AdministratorProfile;
import com.CollegeDirectory.demo.repository.AdministratorProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorProfileService {

  @Autowired
  private AdministratorProfileRepository administratorProfileRepository;

  public List<AdministratorProfile> findAll() {
    return administratorProfileRepository.findAll();
  }

  public Optional<AdministratorProfile> findById(Long id) {
    return administratorProfileRepository.findById(id);
  }

  public AdministratorProfile save(AdministratorProfile administratorProfile) {
    return administratorProfileRepository.save(administratorProfile);
  }

  public void delete(Long id) {
    administratorProfileRepository.deleteById(id);
  }
}
