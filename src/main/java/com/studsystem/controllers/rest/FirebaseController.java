package com.studsystem.controllers.rest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.studsystem.interfaces.FirebaseUploadDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FirebaseController {

    @Value("${secret.admin}")
    private String secretAdmin;

    @Value("${secret.student}")
    private String secretStudent;

    @Value("${secret.teacher}")
    private String secretTeacher;


    @Autowired
    private FirebaseUploadDownloadService uploadDownloadService;

//    @GetMapping("/storage/test")
//    public ResponseEntity getUIDTest(@RequestParam String idToken) throws FirebaseAuthException {
//        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//        if (idToken == null) {
//            return ResponseEntity.badRequest().body("Cannot process the idToken parameter.");
//        }
//        return ResponseEntity.ok().body(firebaseToken.getUid());
//    }

    @PostMapping("/storage/task/upload")
    public ResponseEntity uploadTask(@RequestParam MultipartFile file, @RequestParam String courseId,
                                 @RequestParam String taskId, @RequestParam String idToken) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/storage/solution/upload")
    public ResponseEntity uploadSolution(@RequestParam MultipartFile file, @RequestParam String courseId,
                                         @RequestParam String taskId, @RequestParam String idToken/*ПОЛУЧИТЬ АЙДИ ЮЗЕРА ЗДЕСЯ*/,
                                         @RequestParam String commentary) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/storage/solution/download")
    public ResponseEntity downloadSolution(@RequestParam String courseId, @RequestParam String taskId,
                                           @RequestParam String idToken, @RequestParam String solutionId) {
        // /storage/solution/download?courseId=1231adasd1312&taskId=12313asddas1231&userId=asdads123139vjfjf&solutionId=2112adsdjassda2
        return ResponseEntity.ok().build();
    }

    @GetMapping("/storage/task/download")
    public ResponseEntity downloadTask(@RequestParam String courseId, @RequestParam String taskId) {
        // /storage/task/download?courseId=asd12312asdad&taskId=asdad12313asdad
        return ResponseEntity.ok().build();
    }


//    @PutMapping("/storage/upload/{ref}")
//    public ResponseEntity uploadFile(@PathVariable("ref") String ref,
//                                     @RequestParam("refUID") String refUID,
//                                     @RequestParam("file") MultipartFile multipartFile,
//                                     @RequestParam String idToken,
//                                     @RequestParam String subjectName) throws FirebaseAuthException, IOException {
//        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
//        if (firebaseToken.getUid() != null){
//            uploadDownloadService.uploadFile(multipartFile, ref, refUID, subjectName, firebaseToken.getUid());
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

//    @GetMapping("/storage/download/{ref}/{filename:.+}")
//    public ResponseEntity getFile(@PathVariable("ref") String ref,
//                                  @RequestParam("refUID") String refUID,
//                                  @PathVariable("filename") String filename,
//                                  HttpServletResponse response) throws IOException {
//        if (uploadDownloadService.downloadFile(ref, refUID, filename, response)) {
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }


}
