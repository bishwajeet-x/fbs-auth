package com.flightapp;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flightapp.entity.Role;
import com.flightapp.entity._User;
import com.flightapp.service.UserService;

@SpringBootApplication
public class FbsAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbsAuthApplication.class, args);
	}



	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
  @Bean 
  CommandLineRunner run(UserService userService) { 
	  return args -> {
		  Role admin = new Role(); 
		  admin.setName("ROLE_ADMIN");
		  
		  Role user = new Role(); 
		  user.setName("ROLE_USER");
		  
		  userService.saveRole(admin); 
		  userService.saveRole(user);
		  
		  _User adminUser = new _User(); 
		  adminUser.setName("Admin");
		  adminUser.setPassword("password"); 
		  adminUser.setUsername("admin");
		  adminUser.setRoles(List.of(admin));
		  
		  userService.saveUser(adminUser);
		  
		  userService.addRoleToUser("admin", "ROLE_ADMIN"); 
	  }; 
  }
}
