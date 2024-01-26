package com.cloudapi.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.firebase.cloud.StorageClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    


    @Value("${server.port}")
    private static String PATH;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        
        if (FirebaseApp.getApps().isEmpty()) {
            // Initialize Firebase App
            File f = new File("firebase/s5-cloud-api-file-firebase-adminsdk-7b445-29e99095c2.json");
            InputStream serviceAccount = new FileInputStream(f);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("s5-cloud-api-file.appspot.com")
                    .build();

            FirebaseApp.initializeApp(options);
        }



        // // Get a reference to the Google Cloud Storage service
        // Storage storage = StorageOptions.getDefaultInstance().getService();

        // // Specify the name for the file in Google Cloud Storage
        // String fileName = file.getOriginalFilename();

        // // Get a reference to the bucket
        // Bucket bucket = storage.get("s5-cloud-api-file.appspot.com");

        //   // Upload the file to Google Cloud Storage
        //   BlobId blobId = BlobId.of("s5-cloud-api-file.appspot.com", fileName);
        //   BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        //   storage.create(blobInfo, file.getBytes());

        // // Get the download URL for the uploaded file (Note: Firebase SDK doesn't provide a direct URL retrieval)
        // String downloadUrl = "https://storage.googleapis.com/" + bucket.getName() + "/" + fileName;

        return "File uploaded successfully! Download URL: hello ";
    }


    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Hello Admin");
    }

    @GetMapping("/test-user")
    public ResponseEntity<String> testUser(){
        return ResponseEntity.ok("Hello User");
    }


    public static void main(String[] args) {
        try {
            // Initialize Firebase App
            InputStream serviceAccount = new FileInputStream("firebase/s5-cloud-api-file-firebase-adminsdk-7b445-29e99095c2.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("s5-cloud-api-file.appspot.com")
                    .build();

            FirebaseApp.initializeApp(options);
            StorageClient storageClient = StorageClient.getInstance();
        
            String fileName = "test.png";

            Path localFilePath = Paths.get("firebase/photo.png");

            // Determine the content type based on the file extension (e.g., image/jpeg)
            String contentType = Files.probeContentType(localFilePath);

            // Upload the photo to Firebase Cloud Storage with specified content type
            BlobInfo blobInfo = BlobInfo.newBuilder(storageClient.bucket().getName(), fileName)
                    .setContentType("image/png")
                    .build();

            storageClient.bucket().create(fileName,Files.readAllBytes(localFilePath), contentType);

            System.out.println("File uploaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
