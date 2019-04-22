package com.studsystem.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

    @GetMapping("/users")
    public ResponseEntity getUserProfile(@RequestParam String userId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/users/by-email")
    public ResponseEntity getUserProfileByEmail(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }
}
