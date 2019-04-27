package com.studsystem.interfaces;

import com.google.firebase.auth.FirebaseAuthException;
import com.studsystem.dto.UserProfile;

import java.util.Optional;

public interface FirebaseUserProfileService {
    String createUser(String email, String password, String type, String birthDate,
                    String firstName, String lastName, String middleName,
                    String phone, String photo) throws FirebaseAuthException;
    String deleteUser(String id);
    Optional<UserProfile> getUserByKey(String key);
    Optional<UserProfile> getUserByFirebaseKey(String firebaseKey);
}
