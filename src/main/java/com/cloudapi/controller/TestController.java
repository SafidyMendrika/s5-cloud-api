package com.cloudapi.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

import com.cloudapi.json.Response;
import com.cloudapi.model.Annonce;
import com.cloudapi.util.Util;
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



    @PostMapping("/uploads")
    public ResponseEntity<Response> uploadFiles(@RequestParam("file") ArrayList<MultipartFile> files){
        Response rep= new Response();
        try {
            rep.success("Upload file réussi", Util.uploadFiles(files));
            
        } catch (Exception e) {
            rep.error(e);
        }
        
        return ResponseEntity.ok(rep);

    }

    @PostMapping("/upload")
    public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file){
        Response rep= new Response();
        try {
            rep.success("Upload file réussi", Util.uploadFile(file));
            
        } catch (Exception e) {
            rep.error(e);
        }
        
        return ResponseEntity.ok(rep);

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
        
            

            Path localFilePath = Paths.get("firebase/photo2.png");
            String extension = localFilePath.getFileName().toString().split("\\.")[1];

            String fileName = UUID.randomUUID().toString() + "." + extension;

            // Determine the content type based on the file extension (e.g., image/jpeg)
            String contentType = Files.probeContentType(localFilePath);

            // // Upload the photo to Firebase Cloud Storage with specified content type

            Blob b = storageClient.bucket().create(fileName,Files.readAllBytes(localFilePath), contentType);

            String downloadUrl = storageClient.bucket().get(b.getBlobId().getName()).signUrl(1, TimeUnit.DAYS).toString();
            System.out.println("File uploaded successfully!");
            System.out.println("LINK : "+ downloadUrl);

            System.out.println(localFilePath.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
