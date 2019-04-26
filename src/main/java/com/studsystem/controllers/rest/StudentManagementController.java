package com.studsystem.controllers.rest;

import com.studsystem.dto.StudentProfile;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.StudentsManagementService;
import com.studsystem.lambda.OnValidationFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentManagementController {

    @Autowired
    private StudentsManagementService studentsManagementService;

    @PutMapping("/students")
    public ResponseEntity putStudentProfile(@RequestParam String userId,
                                            @RequestParam String additionalInfo,
                                            @RequestParam float averageScore,
                                            @RequestParam String groupId) {
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        UserProfile up = UserProfile.getInstance().setKey(userId, null, failureCallback);
        StudentProfile sp = StudentProfile.getInstance().setAdditionalInfo(additionalInfo, null, failureCallback)
                .setAverageScore(averageScore, null, failureCallback)
                .setGroupKey(groupId, null, failureCallback);
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        if (studentsManagementService.addStudentProfileToUserProfile(up, sp)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Firebase interaction was interrupted.");
        }
    }

}
