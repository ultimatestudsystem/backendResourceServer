package com.studsystem.repository;

import com.studsystem.dto.StudentProfile;
import com.studsystem.interfaces.repository.StudentProfileFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentProfileFirebaseRepositoryImpl implements StudentProfileFirebaseRepository {
    @Override
    public boolean save(StudentProfile object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public StudentProfile get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
