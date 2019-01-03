package com.project.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UsermanagementApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("vivek"));
		SpringApplication.run(UsermanagementApplication.class, args);
	}
}
