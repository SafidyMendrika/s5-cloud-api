package com.cloudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapi.dto.NotificationMessage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FirebaseMessagingService {
    
    @Autowired
    FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(NotificationMessage notificationMessage) throws Exception{
        Notification notification =  Notification
        .builder()
        .setBody(notificationMessage.getBody())
        .setTitle(notificationMessage.getTitle())
        .setImage(notificationMessage.getImage())
        .build();

        Message message = Message
        .builder()
        .setToken(notificationMessage.getRecipientToken())
        .setNotification(notification)
        .putAllData(notificationMessage.getData())
        .build();

        try {
            firebaseMessaging.send(message);

            return "envoyé";
        } catch (Exception e) {
            e.printStackTrace();
            return "erreur";
            // TODO: handle exception
        }

    }
}
