package com.CollegeDirectory.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CollegeDirectory.demo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}