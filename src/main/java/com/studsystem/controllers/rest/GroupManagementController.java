package com.studsystem.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studsystem.dto.StudyGroup;
import com.studsystem.interfaces.GroupManagementService;
import com.studsystem.interfaces.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class GroupManagementController {

    @Autowired
    private GroupManagementService groupManagementService;

    @Autowired
    private HelperService helperService;

    @PutMapping("/groups/create-group")
    public ResponseEntity createGroup(@RequestParam String groupName) {
//        StudyGroup sg = new StudyGroup();
//        sg.setGroupIdentifier(groupName);
//        if (groupManagementService.createGroup(sg)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.badRequest().body("The group is not unique or async operations" +
//                    "was interrupted.");
//        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/groups/get-all-groups")
    public ResponseEntity getAllGroups () {
        List<StudyGroup> allGroups = groupManagementService.getAllGroups();
        String serializedResult;
        try {
            serializedResult = helperService.getObjectMapper().writeValueAsString(allGroups);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot serialize the list of groups.");
        }
        if (serializedResult == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Serialized object is null");
        }
        return ResponseEntity.ok().body(serializedResult);
    }

    @PutMapping("/groups/add-to-group")
    public ResponseEntity addToGroup(@RequestParam String userId,
                                     @RequestParam String groupId) {
//        UserProfile up = new UserProfile();
//        up.setKey(userId);
//        StudyGroup sg = new StudyGroup();
//        sg.setKey(groupId);
//        if (groupManagementService.addToGroup(up, sg)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.badRequest().body("Either async operations was interrupted or not valid email or" +
//                    "group identifier.");
//        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }
}
