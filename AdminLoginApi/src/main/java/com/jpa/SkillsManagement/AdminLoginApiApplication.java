package com.jpa.SkillsManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminLoginApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminLoginApiApplication.class, args);
	}

}
