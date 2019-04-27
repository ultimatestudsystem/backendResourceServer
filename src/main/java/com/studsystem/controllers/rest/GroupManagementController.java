package com.studsystem.controllers.rest;

import com.studsystem.dto.StudyGroup;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.GroupManagementService;
import com.studsystem.lambda.OnValidationFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class GroupManagementController {

    @Autowired
    private GroupManagementService groupManagementService;

    @PutMapping("/groups/create-group")
    public ResponseEntity createGroup(@RequestParam String groupName) {
        AtomicReference<String> groupValidationMessage = new AtomicReference<>();
        StudyGroup sg = StudyGroup.getInstance()
            .setStudentKeys(new ArrayList<>(), null, (dto, message) -> groupValidationMessage.set(message));
        if (!groupValidationMessage.get().isEmpty()) {
            return ResponseEntity.badRequest().body(groupValidationMessage.get());
        }
        if (groupManagementService.createGroup(sg)) {
            return ResponseEntity.ok().body(sg);
        } else {
            return ResponseEntity.badRequest().body("The group is not unique or async operations" +
                    "was interrupted.");
        }
    }

    @PutMapping("/groups/add-to-group")
    public ResponseEntity addToGroup(@RequestParam String userId,
                                     @RequestParam String groupId) {
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        UserProfile up = UserProfile.getInstance().setKey(userId, null, failureCallback);
        StudyGroup sg = StudyGroup.getInstance().setKey(groupId, null, failureCallback);
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        if (groupManagementService.addToGroup(up, sg)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot add student with userID-" + userId + " to group with groupID-" + groupId);
        }
    }
}
