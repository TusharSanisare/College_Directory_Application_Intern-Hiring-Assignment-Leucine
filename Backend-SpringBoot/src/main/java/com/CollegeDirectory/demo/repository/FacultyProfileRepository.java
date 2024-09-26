package com.CollegeDirectory.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CollegeDirectory.demo.model.FacultyProfile;

@Repository
public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {

}