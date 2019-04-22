package com.studsystem.services;

import com.studsystem.dto.*;
import com.studsystem.enums.SolutionState;
import com.studsystem.interfaces.ProfessorsManagementService;
import com.studsystem.interfaces.repository.ProfessorProfileFirebaseRepository;
import com.studsystem.interfaces.repository.TaskFirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorsManagementServiceImpl implements ProfessorsManagementService {

    @Autowired
    private ProfessorProfileFirebaseRepository professorProfileFirebaseRepository;

    @Autowired
    private TaskFirebaseRepository taskFirebaseRepository;

    @Override
    public boolean addTaskToCourse(Task task) throws InterruptedException {
        return taskFirebaseRepository.save(task);
    }

    @Override
    public List<Task> getTasksOfCourse(Course course) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public List<StudentProfile> getStudentsOfCourse(Course course) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public List<Solution> getSolutionsOfTask(Task task) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Optional<ProfessorProfile> getProfessorProfileOfCourse(Course course) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Optional<ProfessorProfile> getProfessorProfile(String userKey) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean setSolutionStatus(Solution solution, SolutionState state) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Optional<SolutionState> getSolutionStatus(Solution solution) {
        throw new RuntimeException("Not yet implemented");
    }
}
