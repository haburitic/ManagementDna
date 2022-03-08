package com.proyect.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class ManagementDnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementDnaApplication.class, args);
	}

}
