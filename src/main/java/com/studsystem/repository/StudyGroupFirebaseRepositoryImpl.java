package com.studsystem.repository;

import com.studsystem.dto.StudyGroup;
import com.studsystem.interfaces.repository.StudyGroupFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudyGroupFirebaseRepositoryImpl implements StudyGroupFirebaseRepository {
    @Override
    public boolean save(StudyGroup object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public StudyGroup get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
