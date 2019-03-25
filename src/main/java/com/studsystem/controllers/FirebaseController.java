package com.studsystem.controllers;

import com.google.common.io.Files;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FirebaseController {

    @Value("${storage.path}")
    private String storagePath;

    @GetMapping("/test")
    public String getUIDTest(@RequestParam String idToken) throws FirebaseAuthException {
        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        return firebaseToken.getUid();
    }

    @PutMapping("/storage/upload/{refUID}/{ref}")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                     @RequestParam String idToken,
                                     @PathVariable("refUID") String refUID,
                                     @PathVariable("ref") String ref,
                                     @RequestParam(required = false) String hwSubjectName) throws FirebaseAuthException, IOException {
        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        if (firebaseToken.getUid() != null){
            File refUIDFolder = new File(storagePath, refUID);
            if (refUIDFolder.exists() || refUIDFolder.mkdirs()){
                File refFolder = new File(refUIDFolder, ref);
                if (refFolder.exists() || refFolder.mkdirs()){
                    String key = null;
                    DatabaseReference dataRef = null;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    if (hwSubjectName != null && ref.equals("homeworks")){
                        dataRef = database.getReference(ref)
                                .child(refUID)
                                .child(hwSubjectName)
                                .push();
                        key = dataRef.getKey();
                    }else if (ref.equals("conversations")){
                        dataRef = database.getReference(ref)
                                .child(refUID)
                                .push();
                        key = dataRef.getKey();
                    }
                    System.out.println(key);
                    if (key != null && dataRef != null) {
                        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                        System.out.println("Extension: "+ extension);
                        String fileName = key + "." + extension;
                        File file = new File(refFolder, fileName);
                        multipartFile.transferTo(file);
                        Map<String, String> map = new HashMap<>();
                        map.put("date", String.valueOf(new Date()));
                        map.put("message", ref+"/"+fileName);
                        dataRef.setValueAsync(map);
                    }
                }
            }
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{refUID}/{ref}/{filename:.+}")
    public ResponseEntity getFile(@PathVariable("ref") String ref,
                                  @PathVariable("refUID") String refUID,
                                  @PathVariable("filename") String filename,
                                  HttpServletResponse response) throws IOException {
        File folderRefUID = new File(storagePath, refUID);
        if (folderRefUID.exists()){
            File folderRef = new File(folderRefUID, ref);
            if (folderRef.exists()){
                File file = new File(folderRef, filename);
                if (file.exists()){
                    String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file);
                    response.setContentType(contentType);
                    FileUtils.copyFile(file, response.getOutputStream());
                    return ResponseEntity.ok().build();
                }
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
