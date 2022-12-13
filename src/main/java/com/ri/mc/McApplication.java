package com.ri.mc;

import java.util.LinkedHashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ri.mc.entity.Role;
import com.ri.mc.entity.User;
import com.ri.mc.services.UserService;

@SpringBootApplication
public class McApplication {

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}



	// Step 2:

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}



	@Bean
	CommandLineRunner run (UserService userService) {
		return args -> {

			// WHENEVER SERVER HAS INITIALIZED

			// ADD SOME ROLES TO DATABASE
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			// ADD SOME USER TO DB
			userService.saveUser(new User(null, "aaa", "aaa", "123", "aaa@mail.com", new LinkedHashSet<Role>()));
			userService.saveUser(new User(null, "bbb", "bbb", "123", "bbb@mail.com", new LinkedHashSet<Role>()));
			userService.saveUser(new User(null, "ccc", "ccc", "123", "ccc@mail.com", new LinkedHashSet<Role>()));
			userService.saveUser(new User(null, "ddd", "ddd", "123", "ddd@mail.com", new LinkedHashSet<Role>()));

			// ADD ROLES TO USER (RANDOMELY)
			userService.addRoleToUser("aaa", "ROLE_USER");
			userService.addRoleToUser("aaa", "ROLE_MANAGER");
			userService.addRoleToUser("bbb", "ROLE_MANAGER");
			userService.addRoleToUser("ccc", "ROLE_ADMIN");
			userService.addRoleToUser("ddd", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("ddd", "ROLE_ADMIN");
			userService.addRoleToUser("ddd", "ROLE_USER");
		};
	}
}
