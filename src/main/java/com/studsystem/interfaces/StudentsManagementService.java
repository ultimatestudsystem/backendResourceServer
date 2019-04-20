package com.studsystem.interfaces;

import com.studsystem.dto.Course;
import com.studsystem.dto.Solution;
import com.studsystem.dto.StudentProfile;
import com.studsystem.dto.Task;

import java.util.List;

public interface StudentsManagementService {
    boolean addSolutionToTask(StudentProfile studentProfile, Solution solution, Task task);
    Solution getSolutionFromTask(StudentProfile studentProfile, Task task);
    List<Task> getTasksOfCourse(StudentProfile studentProfile, Course course);
    StudentProfile getStudentProfile(String userId);
}
