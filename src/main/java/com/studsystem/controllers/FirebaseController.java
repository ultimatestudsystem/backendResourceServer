package com.studsystem.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.studsystem.services.FirebaseUploadDownloadService;
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

    @GetMapping("/test")
    public String getUIDTest(@RequestParam String idToken) throws FirebaseAuthException {
      /*  UserRecord.CreateRequest request = new UserRecord.CreateRequest();
        request.setEmail("demirel6777teacher@gmail.com");
        request.setPassword("test12");
        UserRecord user = FirebaseAuth.getInstance().createUser(request);
        Map<String, Object> claims = new HashMap<>();
        claims.put("isTeacher",true);
        claims.put("secret", secretTeacher);
        FirebaseAuth.getInstance().setCustomClaims(user.getUid(),claims );
      */  FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        return firebaseToken.getUid();
    }



    @PutMapping("/storage/upload/{ref}")
    public ResponseEntity uploadFile(@PathVariable("ref") String ref,
                                     @RequestParam("refUID") String refUID,
                                     @RequestParam("file") MultipartFile multipartFile,
                                     @RequestParam String idToken,
                                     @RequestParam String subjectName) throws FirebaseAuthException, IOException {
        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        if (firebaseToken.getUid() != null){
            uploadDownloadService.uploadFile(multipartFile, ref, refUID, subjectName, firebaseToken.getUid());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/storage/download/{ref}/{filename:.+}")
    public ResponseEntity getFile(@PathVariable("ref") String ref,
                                  @RequestParam("refUID") String refUID,
                                  @PathVariable("filename") String filename,
                                  HttpServletResponse response) throws IOException {
        if (uploadDownloadService.downloadFile(ref, refUID, filename, response))
            return ResponseEntity.ok().build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
