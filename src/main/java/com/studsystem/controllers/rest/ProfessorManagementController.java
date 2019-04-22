package com.studsystem.controllers.rest;

import com.studsystem.interfaces.ProfessorsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorManagementController {

    @Autowired
    private ProfessorsManagementService professorsManagementService;

    @PutMapping("/professors")
    public ResponseEntity putProfessorProfile(@RequestParam String userId,
                                              @RequestParam String additionalInfo) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }
}
