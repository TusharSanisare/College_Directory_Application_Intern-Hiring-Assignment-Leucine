package com.CollegeDirectory.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.CollegeDirectory.demo.security.dto.LoginRequestDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO userLoginRequest) {
    try {
      // Authenticate user with provided credentials
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          userLoginRequest.getUsername(),
          userLoginRequest.getPassword()));

      // Load the user details
      UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginRequest.getUsername());

      // Generate the JWT token using the user details
      String token = jwtUtil.generateToken(userDetails);
      String role = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
      Long userId = userDetailsService.findUserIdByUsername(userLoginRequest.getUsername());

      // Create response map with token and role
      Map<String, String> response = new HashMap<>();
      response.put("token", token);
      response.put("role", role); // Add role to the response
      response.put("userId", String.valueOf(userId));

      return ResponseEntity.ok(response);

    } catch (Exception e) {
      return ResponseEntity.status(401).build(); // Unauthorized
    }
  }

}
