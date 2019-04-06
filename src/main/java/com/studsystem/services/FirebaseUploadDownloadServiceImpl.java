package com.studsystem.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseUploadDownloadServiceImpl implements FirebaseUploadDownloadService {


    @Value("${storage.path}")
    private String storagePath;

    @Override
    public void uploadFile(MultipartFile multipartFile, String ref, String refUID, String subjectName, String uid) throws IOException {
//        FirebaseAuth.getInstance().getUser(uid)
        Path path = Paths.get(storagePath, refUID, ref);
        File folder = path.toFile();
        if (folder.exists() || folder.mkdirs()){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataRef = database.getReference(ref)
                        .child(refUID)
                        .child(subjectName)
                        .push();
            String key = dataRef.getKey();
            if (key != null) {
                String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                String fileName = key + "." + extension;
                File file = new File(folder, fileName);
                multipartFile.transferTo(file);
                Map<String, String> map = new HashMap<>();
                map.put("date", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
                map.put("message", fileName);

                dataRef.setValueAsync(map);
            }
        }
    }
    @Override
    public boolean downloadFile(String ref, String refUID, String filename, HttpServletResponse response) throws IOException {
        File folderRefUID = new File(storagePath, refUID);
        if (folderRefUID.exists()){
            File folderRef = new File(folderRefUID, ref);
            if (folderRef.exists()){
                File file = new File(folderRef, filename);
                if (file.exists()){
                    String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file);
                    response.setContentType(contentType);
                    FileUtils.copyFile(file, response.getOutputStream());
                    return true;
                }
            }
        }
        return false;
    }
}
