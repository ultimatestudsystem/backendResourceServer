package com.studsystem.controllers.rest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.studsystem.dto.Solution;
import com.studsystem.dto.Task;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.FirebaseUploadDownloadService;
import com.studsystem.interfaces.FirebaseUserProfileService;
import com.studsystem.interfaces.HelperService;
import com.studsystem.lambda.OnValidationFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
public class StorageManagementController {

    @Autowired
    private FirebaseUploadDownloadService uploadDownloadService;

    @Autowired
    private FirebaseUserProfileService firebaseUserProfileService;

    @Autowired
    private HelperService helperService;

    @PostMapping("/storage/task/upload")
    public ResponseEntity uploadTask(@RequestParam MultipartFile file, @RequestParam String courseId,
                                     @RequestParam String taskId, @RequestParam String idToken, HttpServletRequest request) {
        try {
            FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(String.format("There is authentication error: %s", e.getErrorCode()));
        }
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        Task task = Task.getInstance()
                .setCourseKey(courseId, null, failureCallback)
                .setKey(taskId, null, failureCallback);
        if (idToken == null) {
            return ResponseEntity.badRequest().body("Cannot process the idToken parameter.");
        }
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        try {
            if (uploadDownloadService.uploadTaskFile(file, task, request)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("The firebase interaction was interrupted!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(String.format("There is the IO error: %s", e.getLocalizedMessage()));
        }
    }

    @PostMapping("/storage/solution/upload")
    public ResponseEntity uploadSolution(@RequestParam MultipartFile file, @RequestParam String courseId,
                                         @RequestParam String taskId, @RequestParam String idToken,
                                         @RequestParam String commentary, HttpServletRequest request) {
        FirebaseToken firebaseToken;
        try {
            firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(String.format("There is authentication error: %s", e.getErrorCode()));
        }
        if (idToken == null) {
            return ResponseEntity.badRequest().body("Cannot process the idToken parameter.");
        }
        Optional<UserProfile> userProfileOptional = firebaseUserProfileService.getUserByFirebaseKey(firebaseToken.getUid());
        UserProfile userProfile;
        if (userProfileOptional.isPresent()) {
            userProfile = userProfileOptional.get();
        } else {
            return ResponseEntity.badRequest().body(String.format("There is no such User profile with id token: %s", idToken));
        }
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        Solution solution = Solution.getInstance()
                .setCourseKey(courseId, null, failureCallback)
                .setTaskKey(taskId, null, failureCallback)
                .setCommentary(commentary, null, failureCallback)
                .setUploadingDate(helperService.getCurrentTimestamp(), null, failureCallback)
                .setUserKey(userProfile.getKey(), null, null);
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        try {
            if (uploadDownloadService.uploadSolutionFile(file, solution, request)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("The firebase interaction was interrupted!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(String.format("There is the IO error: %s", e.getLocalizedMessage()));
        }
    }

    @GetMapping("/storage/solution/download")
    public ResponseEntity downloadSolution(@RequestParam String courseId, @RequestParam String taskId,
                                           @RequestParam String idToken, @RequestParam String solutionId,
                                           HttpServletResponse response) {
        // /storage/solution/download?courseId=1231adasd1312&taskId=12313asddas1231&userId=asdads123139vjfjf&solutionId=2112adsdjassda2
        FirebaseToken firebaseToken;
        try {
            firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(String.format("There is authentication error: %s", e.getErrorCode()));
        }
        if (idToken == null) {
            return ResponseEntity.badRequest().body("Cannot process the idToken parameter.");
        }
        Optional<UserProfile> userProfileOptional = firebaseUserProfileService.getUserByFirebaseKey(firebaseToken.getUid());
        UserProfile userProfile;
        if (userProfileOptional.isPresent()) {
            userProfile = userProfileOptional.get();
        } else {
            return ResponseEntity.badRequest().body(String.format("There is no such User profile with id token: %s", idToken));
        }
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        Solution solution = Solution.getInstance().setUserKey(userProfile.getKey(), null, null)
                .setCourseKey(courseId, null, failureCallback)
                .setTaskKey(taskId, null, failureCallback)
                .setKey(solutionId, null, failureCallback);
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        try {
            if (uploadDownloadService.downloadSolutionFile(solution, response)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("The firebase interaction was interrupted or file not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(String.format("There is the IO error: %s", e.getLocalizedMessage()));
        }
    }

    @GetMapping("/storage/task/download")
    public ResponseEntity downloadTask(@RequestParam String courseId, @RequestParam String taskId,
                                       @RequestParam String idToken, HttpServletResponse response) {
        // /storage/task/download?courseId=asd12312asdad&taskId=asdad12313asdad
        try {
            FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(String.format("There is authentication error: %s", e.getErrorCode()));
        }
        if (idToken == null) {
            return ResponseEntity.badRequest().body("Cannot process the idToken parameter.");
        }
        StringBuilder validationMessages = new StringBuilder();
        OnValidationFailure failureCallback = (dto, message) -> validationMessages.append(message.concat(" "));
        Task task = Task.getInstance().setCourseKey(courseId, null, failureCallback)
                .setKey(taskId, null, failureCallback);
        if (!validationMessages.toString().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(validationMessages.toString());
        }
        try {
            if (uploadDownloadService.downloadTaskFile(task, response)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("The firebase interaction was interrupted or file not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(String.format("There is the IO error: %s", e.getLocalizedMessage()));
        }
    }
}
