package com.cloudapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.messaging.FirebaseMessaging;




@SpringBootApplication
public class CloudapiApplication {


	@Bean
	StorageClient firebaseStorage() throws Exception{
		FirebaseApp app = null;
        File f = new File("firebase/s5-cloud-api-file-firebase-adminsdk-7b445-29e99095c2.json");
        InputStream serviceAccount = new FileInputStream(f);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("s5-cloud-api-file.appspot.com")
                .build();

        app= FirebaseApp.initializeApp(options, "mirija");


        return StorageClient.getInstance(app);
	}

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
