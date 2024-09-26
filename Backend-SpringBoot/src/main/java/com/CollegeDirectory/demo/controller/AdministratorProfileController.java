package com.CollegeDirectory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.model.AdministratorProfile;
import com.CollegeDirectory.demo.service.AdministratorProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorProfileController {

  @Autowired
  private AdministratorProfileService administratorProfileService;

  @GetMapping
  public List<AdministratorProfile> getAllAdministrators() {
    return administratorProfileService.findAll();
  }

  @GetMapping("bhopra")
  public String getBhopra() {
    return "Yes Bhopra";
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdministratorProfile> getAdministratorById(@PathVariable Long id) {
    Optional<AdministratorProfile> administratorProfile = administratorProfileService.findById(id);
    return administratorProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public AdministratorProfile createAdministrator(@RequestBody AdministratorProfile administratorProfile) {
    return administratorProfileService.save(administratorProfile);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AdministratorProfile> updateAdministrator(@PathVariable Long id,
      @RequestBody AdministratorProfile administratorProfile) {
    administratorProfile.setUserId(id);
    AdministratorProfile updatedAdministratorProfile = administratorProfileService.save(administratorProfile);
    return ResponseEntity.ok(updatedAdministratorProfile);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
    administratorProfileService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
