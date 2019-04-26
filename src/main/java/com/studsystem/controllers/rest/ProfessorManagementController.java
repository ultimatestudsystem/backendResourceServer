package com.studsystem.controllers.rest;

import com.studsystem.dto.ProfessorProfile;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.ProfessorsManagementService;
import com.studsystem.lambda.OnValidationFailure;
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
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        UserProfile up = UserProfile.getInstance().setKey(userId, null, failureCallback);
        ProfessorProfile pp = ProfessorProfile.getInstance().setAdditionalInfo(additionalInfo, null, failureCallback);
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        if (professorsManagementService.addProfessorProfileToUserProfile(up, pp)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Firebase interaction was interrupted.");
        }
    }
}
