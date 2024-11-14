package com.sistdist.diploma_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DiplomaGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomaGeneratorApplication.class, args);
	}

}
