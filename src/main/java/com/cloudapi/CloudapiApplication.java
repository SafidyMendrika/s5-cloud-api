package com.cloudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;




@SpringBootApplication
public class CloudapiApplication {

	@Bean
	FirebaseMessaging firebaseMessaging() throws Exception{
		GoogleCredentials googleCredentials = GoogleCredentials
		.fromStream(new ClassPathResource("gascar-project-firebase.json").getInputStream());

		FirebaseOptions firebaseOptions = FirebaseOptions.builder()
		.setCredentials(googleCredentials).build();

		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions,"gascar");  

		return FirebaseMessaging.getInstance(app);
	}
	public static void main(String[] args) {
		SpringApplication.run(CloudapiApplication.class, args);
	}

}
