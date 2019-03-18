package com.studsystem.init;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ApplicationStartup implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        initFirebase();
    }

    private void initFirebase() throws IOException {
        String fileName = "firebase-config.json";
        Resource resource = new ClassPathResource(fileName);
        if (!resource.exists()){
            throw new FileNotFoundException("Firebase options file not found!");
        }
        InputStream serviceAccount = resource.getInputStream();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://ultimate-studsystem.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
