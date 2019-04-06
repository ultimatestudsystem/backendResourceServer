package com.studsystem.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FirebaseUploadDownloadService {

    void uploadFile(MultipartFile multipartFile, String ref, String refUID, String subjectName, String uid) throws IOException;

    boolean downloadFile(String ref, String refUID, String filename, HttpServletResponse response) throws IOException;
}
