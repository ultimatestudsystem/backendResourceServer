package com.studsystem.services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.Solution;
import com.studsystem.dto.Task;
import com.studsystem.interfaces.FirebaseUploadDownloadService;
import com.studsystem.interfaces.repository.SolutionFirebaseRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseUploadDownloadServiceImpl implements FirebaseUploadDownloadService {

    @Value("${storage.path}")
    private String storagePath;

    @Override
    public boolean uploadTaskFile(MultipartFile content, Task task) throws IOException {
        Path path = Paths.get(storagePath, "tasks");
        File folder = path.toFile();
        if (folder.exists() || folder.mkdirs()) {
            String extension = FilenameUtils.getExtension(content.getOriginalFilename());
            String key = task.getCourseKey() + "-" + task.getKey();
            File file = new File(folder, key + "." + extension);
            content.transferTo(file);
            return true;
        }
        return false;
    }

    @Override
    public boolean uploadSolutionFile(MultipartFile content, Solution solution) throws IOException {
        Path path = Paths.get(storagePath, "solutions");
        File folder = path.toFile();
        if (folder.exists() || folder.mkdirs()) {
            String extension = FilenameUtils.getExtension(content.getOriginalFilename());
            String key = solution.getCourseKey() + "-" + solution.getUserKey()
                    + "-" + solution.getTaskKey() + "-" + solution.getKey();
            File file = new File(folder, key + "." + extension);
            content.transferTo(file);
            DatabaseReference thisSolution = FirebaseDatabase.getInstance()
                    .getReference(String.format("solutions/%s/%s/%s/%s", solution.getCourseKey(),
                            solution.getUserKey(), solution.getTaskKey(), solution.getKey()));
            Map<String, String> linkValue = new HashMap<>();
            linkValue.put("solution_file_link", file.getAbsolutePath());
            thisSolution.setValueAsync(linkValue);
            return true;
        }
        return false;
    }

    @Override
    public boolean downloadSolutionFile(Solution solution, HttpServletResponse response) throws IOException {
        return false;
    }

    @Override
    public boolean downloadTaskFile(Task task, HttpServletResponse response) throws IOException {
        return false;
    }


//    @Override
//    public void uploadFile(MultipartFile multipartFile, String firebasePath, String refUID, String subjectName, String uid) throws IOException {
//        Path path = Paths.get(storagePath, refUID, firebasePath);
//        File folder = path.toFile();
//        if (folder.exists() || folder.mkdirs()){
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
//            DatabaseReference dataRef = database.getReference(firebasePath)
//                        .child(refUID)
//                        .child(subjectName)
//                        .push();
//            String key = dataRef.getKey();
//            if (key != null) {
//                String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
//                String fileName = key + "." + extension;
//                File file = new File(folder, fileName);
//                multipartFile.transferTo(file);
//                Map<String, String> map = new HashMap<>();
//                map.put("date", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
//                map.put("message", fileName);
//                dataRef.setValueAsync(map);
//            }
//        }
//    }
//
//    @Override
//    public boolean downloadFile(String ref, String refUID, String filename, HttpServletResponse response) throws IOException {
//        File folderRefUID = new File(storagePath, refUID);
//        if (folderRefUID.exists()) {
//            File folderRef = new File(folderRefUID, ref);
//            if (folderRef.exists()) {
//                File file = new File(folderRef, filename);
//                if (file.exists()) {
//                    String contentType = MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(file);
//                    response.setContentType(contentType);
//                    FileUtils.copyFile(file, response.getOutputStream());
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
