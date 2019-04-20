package com.studsystem.interfaces;

import com.studsystem.dto.*;
import com.studsystem.enums.SolutionState;

import java.util.List;

public interface ProfessorsManagementService {

    boolean addTaskToCourse(ProfessorProfile professorProfile, Task task);

    List<Task> getTasksOfCourse(Course course);
    List<StudentProfile> getStudentsOfCourse(Course course);
    List<Solution> getSolutionsOfTask(Course course, Task task);

    ProfessorProfile getProfessorProfileOfCourse(Course course);

    ProfessorProfile getProfessorProfile(String userKey);

    boolean setSolutionStatusOfStudentInCourseOfTask(Course course, StudentProfile studentProfile, Task task,
                                                     Solution solution, SolutionState state);
    SolutionState getSolutionStatusOfStudentInCourseOfTask(Course course, StudentProfile studentProfile, Task task,
                                                           Solution solution);
}
