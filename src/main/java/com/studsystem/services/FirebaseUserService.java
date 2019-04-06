package com.studsystem.services;

import com.google.firebase.auth.FirebaseAuthException;

public interface FirebaseUserService {
    void createUser(String email, String password, String type) throws FirebaseAuthException;

    void createUser(String email, String password, String type, String secret) throws FirebaseAuthException;
}
