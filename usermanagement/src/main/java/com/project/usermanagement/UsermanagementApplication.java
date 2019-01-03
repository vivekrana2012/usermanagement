package com.project.usermanagement;

import com.project.usermanagement.configuration.BasicAuthConfig;
import com.project.usermanagement.service.CustomUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UsermanagementApplication {

	public static void main(String[] args) {
		String cryptedPassword = new BCryptPasswordEncoder().encode("vivek");
		System.out.println(cryptedPassword);
		SpringApplication.run(UsermanagementApplication.class, args);
	}
}
