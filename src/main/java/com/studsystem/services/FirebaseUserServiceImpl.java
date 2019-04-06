package com.studsystem.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.studsystem.enums.UserType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseUserServiceImpl implements FirebaseUserService {

    @Value("${secret.student}")
    private String secretStudent;

    @Value("${secret.teacher}")
    private String secretTeacher;

    private Map<String, String> secrets ;

    public FirebaseUserServiceImpl() {
        secrets = new HashMap<>();
        secrets.put(UserType.STUDENT.name().toLowerCase(),  secretStudent);
        secrets.put(UserType.TEACHER.name().toLowerCase(),  secretTeacher);
    }

    @Override
    public void createUser(String email, String password, String type) throws FirebaseAuthException {
        createUser(email, password, type, secrets.get(type));
    }

    @Override
    public void createUser(String email, String password, String type, String secret) throws FirebaseAuthException {
        type = type.toLowerCase();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail(email);
        request.setPassword(password);
        UserRecord user = FirebaseAuth.getInstance().createUser(request);
        Map<String, Object> claims = new HashMap<>();
        claims.put(type,true);
        claims.put("secret", secret);
        FirebaseAuth.getInstance().setCustomClaims(user.getUid(),claims );
    }
}
