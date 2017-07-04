package org.exampledriven.springboottestingworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootTestingWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingWorkshopApplication.class, args);
	}
}
