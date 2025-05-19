package com.example.SpringBootStarterDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootStarterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterDemoApplication.class, args);
	}

}
