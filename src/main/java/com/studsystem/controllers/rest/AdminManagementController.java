package com.studsystem.controllers.rest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.studsystem.interfaces.FirebaseUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminManagementController {

    @Autowired
    private FirebaseUserProfileService firebaseUserService;

    @PutMapping("/admin/create-user")
    public ResponseEntity createUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String type,
                                     @RequestParam String birthDate,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String middleName,
                                     @RequestParam String phone,
                                     @RequestParam String photo) {
        try {
            firebaseUserService.createUser(email, password, type, birthDate, firstName,
                    lastName, middleName, phone, photo);
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

    @GetMapping("/")
    public ResponseEntity index() {
        return ResponseEntity.notFound().build();
    }

}
