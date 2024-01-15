package com.cloudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableAutoConfiguration
public class CloudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudapiApplication.class, args);
	}

}
