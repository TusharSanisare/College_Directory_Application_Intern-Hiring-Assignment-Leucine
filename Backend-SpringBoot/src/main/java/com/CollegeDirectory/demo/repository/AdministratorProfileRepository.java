package com.CollegeDirectory.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CollegeDirectory.demo.model.AdministratorProfile;

@Repository
public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Long> {

}
