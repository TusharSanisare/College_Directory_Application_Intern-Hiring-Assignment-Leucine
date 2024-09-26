package com.CollegeDirectory.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "FacultyProfile")
public class FacultyProfile {
  @Id
  private Long userId;

  private String photo;
  private Long departmentId;
  private String officeHours;

  @OneToOne
  @MapsId
  @JoinColumn(name = "userId")
  private User user;
}
