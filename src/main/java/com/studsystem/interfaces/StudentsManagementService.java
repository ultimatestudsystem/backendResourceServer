package com.studsystem.interfaces;

import com.studsystem.dto.*;

import java.util.List;
import java.util.Optional;

public interface StudentsManagementService {
    boolean addSolutionToTask(StudentProfile studentProfile, Solution solution, Task task);
    Optional<Solution> getSolutionFromTask(StudentProfile studentProfile, Task task);
    List<Task> getTasksOfCourse(StudentProfile studentProfile, Course course);
    Optional<StudentProfile> getStudentProfile(String userId);
    boolean addStudentProfileToUserProfile(UserProfile up, StudentProfile sp);
}
