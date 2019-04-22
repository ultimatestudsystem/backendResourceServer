package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.StudentProfile;
import com.studsystem.interfaces.repository.StudentProfileFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentProfileFirebaseRepositoryImpl implements StudentProfileFirebaseRepository {
    @Override
    public boolean save(StudentProfile object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<StudentProfile> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<StudentProfile> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}
