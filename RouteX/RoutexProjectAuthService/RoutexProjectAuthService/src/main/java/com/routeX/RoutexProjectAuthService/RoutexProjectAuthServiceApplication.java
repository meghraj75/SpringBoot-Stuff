package com.routeX.RoutexProjectAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RoutexProjectAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutexProjectAuthServiceApplication.class, args);
	}

}
