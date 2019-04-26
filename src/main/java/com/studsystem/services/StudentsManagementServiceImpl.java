package com.studsystem.services;

import com.studsystem.dto.*;
import com.studsystem.interfaces.StudentsManagementService;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsManagementServiceImpl implements StudentsManagementService {

    @Override
    public boolean addSolutionToTask(StudentProfile studentProfile, Solution solution, Task task) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Optional<Solution> getSolutionFromTask(StudentProfile studentProfile, Task task) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public List<Task> getTasksOfCourse(StudentProfile studentProfile, Course course) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Optional<StudentProfile> getStudentProfile(String userId) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean addStudentProfileToUserProfile(UserProfile up, StudentProfile sp) {
        throw new RuntimeException("Not yet implemented");
    }
}
