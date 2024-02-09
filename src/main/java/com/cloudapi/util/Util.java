package com.cloudapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

public class Util {
    

    public static ArrayList<String> uploadFiles(ArrayList<MultipartFile> files)throws Exception{
        ArrayList<String> rep= new ArrayList<String>();
        for (MultipartFile file : files) {
            rep.add(uploadFile(file));
        }
        return rep;
    }




    public static String uploadFile(MultipartFile file)throws Exception{


        for (FirebaseApp e : FirebaseApp.getApps()) {
            System.out.println(e.getName());
        }
        
        StorageClient storageClient = StorageClient.getInstance(FirebaseApp.getInstance("mirija"));

        String extension = file.getOriginalFilename().split("\\.")[1];

        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        Path tempFile = convFile.toPath();

        String fileName = UUID.randomUUID().toString() + "." + extension;  
        String contentType = Files.probeContentType(tempFile);

        Blob b = storageClient.bucket().create(fileName,Files.readAllBytes(tempFile), contentType);

        convFile.delete();

        String downloadUrl = storageClient.bucket().get(b.getBlobId().getName()).signUrl(30, TimeUnit.DAYS).toString();
        return downloadUrl;

    }




}
