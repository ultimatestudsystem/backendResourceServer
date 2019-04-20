package com.studsystem.repository;

import com.studsystem.dto.Course;
import com.studsystem.interfaces.repository.CourseFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CourseFirebaseRepositoryImpl implements CourseFirebaseRepository {
    @Override
    public boolean save(Course object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Course get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
