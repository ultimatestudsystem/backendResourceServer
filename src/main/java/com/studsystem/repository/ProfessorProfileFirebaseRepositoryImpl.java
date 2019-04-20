package com.studsystem.repository;

import com.studsystem.dto.ProfessorProfile;
import com.studsystem.interfaces.repository.ProfessorProfileFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorProfileFirebaseRepositoryImpl implements ProfessorProfileFirebaseRepository {
    @Override
    public boolean save(ProfessorProfile object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public ProfessorProfile get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
