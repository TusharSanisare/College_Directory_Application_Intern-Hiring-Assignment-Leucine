package com.CollegeDirectory.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeDirectory.demo.model.Department;
import com.CollegeDirectory.demo.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

  public Optional<Department> findById(Long id) {
    return departmentRepository.findById(id);
  }

  public Department save(Department department) {
    return departmentRepository.save(department);
  }

  public void delete(Long id) {
    departmentRepository.deleteById(id);
  }
}
