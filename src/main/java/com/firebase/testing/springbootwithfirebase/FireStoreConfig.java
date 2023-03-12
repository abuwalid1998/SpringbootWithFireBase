package com.firebase.testing.springbootwithfirebase;

import com.google.api.client.util.Value;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireStoreConfig {

    @Bean
    public Firestore getFireStore() throws IOException {
        String credentialPath = "C:\\Users\\PC\\OneDrive\\Desktop\\SpringbootWithFireBase\\springbootproject-cac80-firebase-adminsdk-6t8qz-a9a5cf20a3.json";
        var serviceAccount = new FileInputStream(credentialPath);
        var credentials = GoogleCredentials.fromStream(serviceAccount);

        var options = FirestoreOptions.newBuilder()
                .setCredentials(credentials).build();

        return options.getService();
    }
}