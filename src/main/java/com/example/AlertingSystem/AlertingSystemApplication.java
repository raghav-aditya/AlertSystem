package com.example.AlertingSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
@ComponentScan("com.example")
public class AlertingSystemApplication {

	public static void main(String[] args) {
		log.info("Starting Application");
		long start = System.currentTimeMillis();

		SpringApplication.run(AlertingSystemApplication.class, args);

		long end = System.currentTimeMillis();
		log.info("Application Stated Successfully in time: {} miliseconds" , end-start);
	}

}
