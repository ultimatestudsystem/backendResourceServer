package com.studsystem.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.studsystem.dto.*;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.interfaces.ProfessorsManagementService;
import com.studsystem.interfaces.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController()
public class ProfessorManagementController {

    @Autowired
    private ProfessorsManagementService professorsManagementService;

    @Autowired
    private HelperService helperService;

    @GetMapping("/professors")
    public ResponseEntity getProfessorProfile(@RequestParam String userId) {
        String response;
        try {
            ProfessorProfile sp = professorsManagementService.getProfessorProfile(userId);
            if (sp == null) {
                return ResponseEntity.notFound().build();
            }
            response = helperService.getObjectMapper().writeValueAsString(sp);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error during serialization of student profile.");
        }
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/professors")
    public ResponseEntity putProfessorProfile(@RequestParam String userId,
                                              @RequestParam String additionalInfo) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @GetMapping("/students-of-course")
    public ResponseEntity getStudentProfilesOfCourse(@RequestParam String courseId) {
        AtomicBoolean courseNotFound = new AtomicBoolean(false);
        Course course = Course.getInstance().setKey(courseId, null, (dto, message) -> {
            courseNotFound.set(true);
        });
        if (courseNotFound.get()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The course with given id is not found.");
        }
        List<StudentProfile> result = professorsManagementService.getStudentsOfCourse(course);
        String jsonBody;
        try {
           jsonBody = helperService.getObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error during serialization of student profile list.");
        }
        return ResponseEntity.ok().body(jsonBody);
    }

    @GetMapping("/solutions-of-task")
    public ResponseEntity getSolutionsOfTask(@RequestParam String courseId, @RequestParam String taskId,
                                             @RequestParam String professorUserId) {

        StringBuilder courseValidationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> courseValidationMessages.append(message.concat(" "));
        Course course = Course.getInstance()
                .setKey(courseId, null, failureCallback)
                .setProfessorKey(professorUserId, null, failureCallback);

        if (!courseValidationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(courseValidationMessages.toString());
        }

        StringBuilder taskValidationMessages = new StringBuilder();
        Task task = Task.getInstance()
                .setCourseKey(course.getKey(), null, null)
                .setKey(taskId, null, (dto, message) -> taskValidationMessages.append(message.concat(" ")));
        if (!taskValidationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taskValidationMessages.toString());
        }

        List<Solution> result = professorsManagementService.getSolutionsOfTask(course, task);
        String jsonBody;
        try {
            jsonBody = helperService.getObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error during serialization of solution list.");
        }
        return ResponseEntity.ok().body(jsonBody);
    }

    @GetMapping("/get-tasks-of-course")
    public ResponseEntity getTasksOfCourse(@RequestParam String courseId) {
//        Course course = new Course();
//        course.setKey(courseId);
//        ProfessorProfile pp = professorsManagementService.getProfessorProfileOfCourse(course);
//        List<Task> result = professorsManagementService.getTasksOfCourse(pp, course);
//        if (pp == null || result == null) {
//            return ResponseEntity.badRequest().body("Professor profile of course was not found or" +
//                    "tasks was not loaded correctly.");
//        }
//        String bodyString;
//        try {
//            bodyString = helperService.getObjectMapper().writeValueAsString(result);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot convert list of tasks to JSON.");
//        }
//        if (bodyString == null) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Converted to JSON string is null!");
//        }
//        return ResponseEntity.ok().body(bodyString);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }

    @PutMapping("/add-task-to-course")
    public ResponseEntity addTaskToCourse(@RequestParam String courseId,
                                          @RequestParam String description,
                                          @RequestParam String expirationDate,
                                          @RequestParam int maxTriesNum,
                                          @RequestParam String name,
                                          @RequestParam String taskFileLink,
                                          @RequestParam String professorId) {
//        ProfessorProfile pp = new ProfessorProfile();
//        pp.setKey(professorId);
//        Task t = new Task();
//        t.setCourseKey(courseId);
//        t.setDescription(description);
//        t.setExpirationDate(expirationDate);
//        t.setMaxTriesNum(maxTriesNum);
//        t.setName(name);
//        t.setTaskFileLink(taskFileLink);
//        String currentTimestamp = helperService.getCurrentTimestamp();
//        t.setLastUpdatingDate(currentTimestamp);
//        t.setUploadingDate(currentTimestamp);
//        if (professorsManagementService.addTaskToCourse(pp, t)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Task adding was interrupted");
//        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not yet implemented");
    }
}
