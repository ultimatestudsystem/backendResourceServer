package com.studsystem.init;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.studsystem.enums.UserType;
import com.studsystem.interfaces.FirebaseUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${admin.password}")
    private String adminPass;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${secret.admin}")
    private String secretAdmin;

    @Autowired
    private FirebaseUserProfileService firebaseUserService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        initFirebase();
        createAdminUser();
    }

    private void createAdminUser() {
        new Thread(() -> {
            try {
                FirebaseAuth.getInstance().getUserByEmail(adminEmail);
            }catch (FirebaseAuthException e){
                try {
                    firebaseUserService.createUser(adminEmail, adminPass, UserType.ADMIN.name().toLowerCase(),
                            "NONE", "NONE", "NONE", "NONE", "NONE", "NONE");
                } catch (FirebaseAuthException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
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
