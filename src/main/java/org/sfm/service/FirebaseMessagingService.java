package org.sfm.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FirebaseMessagingService {

    public String sendNotification(Map<String, String> data, String targetToken) throws FirebaseMessagingException {
        // Build the message
        Message message = Message.builder()
                .putAllData(data)
                .setToken(targetToken)  // targetToken is the recipient device's FCM token
                .build();

        // Send the message and return the message ID from Firebase
        return FirebaseMessaging.getInstance().send(message);
    }
}
