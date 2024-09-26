package com.CollegeDirectory.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.model.Department;
import com.CollegeDirectory.demo.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  // @GetMapping
  // public String getAllDepartments() {
  // return "department bhopra";
  // }
  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    return departmentService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Department createDepartment(@RequestBody Department department) {
    return departmentService.save(department);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
    department.setId(id);
    return ResponseEntity.ok(departmentService.save(department));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
    departmentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
