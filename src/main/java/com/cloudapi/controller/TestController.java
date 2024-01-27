package com.cloudapi.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.google.firebase.cloud.StorageClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
    public ResponseEntity<Response> test(){
        Response rep = new Response();
        try {
            Resource resource = new ClassPathResource("firebase/s5-cloud-api-file-firebase-adminsdk-7b445-29e99095c2.json");
            File f = resource.getFile();
            rep.success("success", f.getName());
        } catch (Exception e) {
            rep.error(e);
            // TODO: handle exception
        }
       
        return ResponseEntity.ok(rep);
    }

    @GetMapping("/test-user")
    public ResponseEntity<String> testUser(){
        return ResponseEntity.ok("Hello User");
    }


    public static void main(String[] args) {
        try {
                // Spécifiez le chemin complet du fichier que vous souhaitez convertir en base64
                String filePath = "firebase/photo.png";

                    File file = new File(filePath);
        
                    // Convertir le fichier en tableau de bytes
                    byte[] fileBytes = new byte[(int) file.length()];
                    try (FileInputStream fileInputStream = new FileInputStream(file)) {
                        fileInputStream.read(fileBytes);
                    }
        
                    // Convertir le tableau de bytes en chaîne base64
                    String base64String = Base64.getEncoder().encodeToString(fileBytes);
        
                    System.out.println("La chaîne base64 du fichier est : " + base64String);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
