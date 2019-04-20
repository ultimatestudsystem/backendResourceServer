package com.studsystem.services;

import com.studsystem.dto.Course;
import com.studsystem.dto.Solution;
import com.studsystem.dto.StudentProfile;
import com.studsystem.dto.Task;
import com.studsystem.interfaces.StudentsManagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsManagementServiceImpl implements StudentsManagementService {

    @Override
    public boolean addSolutionToTask(StudentProfile studentProfile, Solution solution, Task task) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Solution getSolutionFromTask(StudentProfile studentProfile, Task task) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public List<Task> getTasksOfCourse(StudentProfile studentProfile, Course course) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public StudentProfile getStudentProfile(String userId) {
        throw new RuntimeException("Not yet implemented");
    }
}
