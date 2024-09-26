package com.CollegeDirectory.demo.security.dto;

public class JwtResponse {
  private String token;

  public JwtResponse(String token) {
    this.token = token;
  }

  // Getter for token
  public String getToken() {
    return token;
  }
}
