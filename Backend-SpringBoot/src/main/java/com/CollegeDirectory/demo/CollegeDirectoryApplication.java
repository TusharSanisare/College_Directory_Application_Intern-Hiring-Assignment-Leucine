package com.CollegeDirectory.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CollegeDirectoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(CollegeDirectoryApplication.class, args);
		System.out.println("Started...");

		// String rawPassword = "p";
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String encodedPassword = passwordEncoder.encode(rawPassword);
		// System.out.println(rawPassword + encodedPassword);
	}
}
