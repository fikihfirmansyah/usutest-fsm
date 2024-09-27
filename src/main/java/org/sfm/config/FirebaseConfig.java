package org.sfm.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            String firebaseConfigPath = System.getenv("FIREBASE_Cmvn clean install\nONFIG");
            if (firebaseConfigPath == null) {
                throw new IllegalStateException("FIREBASE_CONFIG environment variable not set");
            }

            FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase has been initialized");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
