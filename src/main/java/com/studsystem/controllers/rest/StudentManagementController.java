package com.studsystem.controllers.rest;

import com.studsystem.interfaces.HelperService;
import com.studsystem.interfaces.StudentsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentManagementController {

    @Autowired
    private StudentsManagementService studentsManagementService;

    @Autowired
    private HelperService helperService;

    @PutMapping("/students")
    public ResponseEntity putStudentProfile(@RequestParam String userId,
                                            @RequestParam String additionalInfo,
                                            @RequestParam float averageScore,
                                            @RequestParam String groupId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @PutMapping("/students/add-solution")
    public ResponseEntity addSolutionToTask(@RequestParam String userId,
                                            @RequestParam String courseId,
                                            @RequestParam String taskId,
                                            @RequestParam String commentary,
                                            @RequestParam String solutionFileLink) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/students/get-solution")
    public ResponseEntity getSolution(@RequestParam String userId,
                                      @RequestParam String courseId,
                                      @RequestParam String taskId,
                                      @RequestParam String solutionId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }
}
