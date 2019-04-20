package com.studsystem.repository;

import com.studsystem.dto.Task;
import com.studsystem.interfaces.repository.TaskFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskFirebaseRepositoryImpl implements TaskFirebaseRepository {
    @Override
    public boolean save(Task object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Task get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
