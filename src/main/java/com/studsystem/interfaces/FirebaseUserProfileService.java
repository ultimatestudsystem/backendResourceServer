package com.studsystem.interfaces;

import com.google.firebase.auth.FirebaseAuthException;
import com.studsystem.dto.UserProfile;

public interface FirebaseUserProfileService {

    String createUser(String email, String password, String type, String birthDate,
                    String firstName, String lastName, String middleName,
                    String phone, String photo) throws FirebaseAuthException;

    String createUser(String email, String password, String type, String birthDate,
                    String firstName, String lastName, String middleName,
                    String phone, String photo, String secret) throws FirebaseAuthException;

    String deleteUser(String id);

    UserProfile getUserByKey(String key);
}