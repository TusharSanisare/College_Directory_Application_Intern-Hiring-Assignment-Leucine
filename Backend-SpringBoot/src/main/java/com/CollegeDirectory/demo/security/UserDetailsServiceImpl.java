package com.CollegeDirectory.demo.security;

import com.CollegeDirectory.demo.model.User;
import com.CollegeDirectory.demo.repository.UserRepository; // Your UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Find the user from the database using the repository
    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }

    // Define the roles/authorities based on the user's role
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(user.getRole()));

    // Create a UserDetails object to return to Spring Security
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }

  public Long findUserIdByUsername(String username) {
    User user = userRepository.findByUsername(username);
    return user.getId();
  }
}
