package com.studsystem.services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.*;
import com.studsystem.enums.SolutionState;
import com.studsystem.interfaces.ProfessorsManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class ProfessorsManagementServiceImpl implements ProfessorsManagementService {

    @Override
    public boolean addTaskToCourse(ProfessorProfile professorProfile, Task task) {
        AtomicBoolean result = new AtomicBoolean(true);
        DatabaseReference tasksReference = FirebaseDatabase.getInstance().getReference("tasks/" + task.getCourseKey());
        DatabaseReference newTaskReference = tasksReference.push();
        DatabaseReference.CompletionListener cl = (error, ref) -> {
            if (error == null) {
                result.set(false);
            }
        };
        newTaskReference.child("description").setValue(task.getDescription(), cl);
        newTaskReference.child("expiration_date").setValue(task.getExpirationDate(), cl);
        newTaskReference.child("last_updating_date").setValue(task.getLastUpdatingDate(), cl);
        newTaskReference.child("max_tries_num").setValue(task.getMaxTriesNum(), cl);
        newTaskReference.child("name").setValue(task.getName(), cl);
        newTaskReference.child("task_file_link").setValue(task.getTaskFileLink(), cl);
        newTaskReference.child("uploading_date").setValue(task.getUploadingDate(), cl);
        return result.get();
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
    public List<Solution> getSolutionsOfTask(Course course, Task task) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public ProfessorProfile getProfessorProfileOfCourse(Course course) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public ProfessorProfile getProfessorProfile(String userKey) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public boolean setSolutionStatusOfStudentInCourseOfTask(Course course, StudentProfile studentProfile, Task task, Solution solution, SolutionState state) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public SolutionState getSolutionStatusOfStudentInCourseOfTask(Course course, StudentProfile studentProfile, Task task, Solution solution) {
        throw new RuntimeException("Not yet implemented");
    }
}
