package com.studsystem.interfaces;

import com.studsystem.dto.*;
import com.studsystem.enums.SolutionState;

import java.util.List;
import java.util.Optional;

public interface ProfessorsManagementService {
    boolean addTaskToCourse(Task task) throws InterruptedException;
    List<Task> getTasksOfCourse(Course course);
    List<StudentProfile> getStudentsOfCourse(Course course);
    List<Solution> getSolutionsOfTask(Task task);
    Optional<ProfessorProfile> getProfessorProfileOfCourse(Course course);
    Optional<ProfessorProfile> getProfessorProfile(String userKey);
    boolean setSolutionStatus(Solution solution, SolutionState state);
    Optional<SolutionState> getSolutionStatus(Solution solution);
}
