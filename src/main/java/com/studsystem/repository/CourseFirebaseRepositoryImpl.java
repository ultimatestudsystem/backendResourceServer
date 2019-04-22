package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.Course;
import com.studsystem.interfaces.repository.CourseFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CourseFirebaseRepositoryImpl implements CourseFirebaseRepository {
    @Override
    public boolean save(Course object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Course> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Course> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}