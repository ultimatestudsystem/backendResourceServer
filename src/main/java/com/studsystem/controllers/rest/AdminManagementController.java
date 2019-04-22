package com.studsystem.controllers.rest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.studsystem.interfaces.FirebaseUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminManagementController {

    @Autowired
    private FirebaseUserProfileService firebaseUserService;

    @PutMapping("/admin/create-user")
    public ResponseEntity createUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String userType,
                                     @RequestParam String birthDate,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String middleName,
                                     @RequestParam String phone,
                                     @RequestParam String photo) {
        try {
            String validationMessage = firebaseUserService.createUser(email, password, userType, birthDate, firstName,
                    lastName, middleName, phone, photo);
            if (!validationMessage.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessage);
            }
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Auth Exception occurred");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin/delete-user")
    public ResponseEntity deleteUser(@RequestParam String firebaseUid,
                                     @RequestParam String userId) {
        try {
            FirebaseAuth.getInstance().deleteUser(firebaseUid);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Auth Exception occurred");
        }
        String removalResult = firebaseUserService.deleteUser(userId);
        if (!removalResult.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(removalResult);
        }
        return ResponseEntity.ok().build();
    }

}
