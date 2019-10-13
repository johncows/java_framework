package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedualApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedualApplication.class, args);
	}

}
