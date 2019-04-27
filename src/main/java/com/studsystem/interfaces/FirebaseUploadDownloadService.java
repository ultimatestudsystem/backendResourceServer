package com.studsystem.interfaces;

import com.studsystem.dto.Solution;
import com.studsystem.dto.Task;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FirebaseUploadDownloadService {

    boolean uploadTaskFile(MultipartFile content, Task task, HttpServletRequest request) throws IOException;
    boolean uploadSolutionFile(MultipartFile file, Solution solution, HttpServletRequest request) throws IOException;

    boolean downloadSolutionFile(Solution solution, HttpServletResponse response) throws IOException;
    boolean downloadTaskFile(Task task, HttpServletResponse response) throws IOException;
}
