package com.studsystem.repository;

import com.studsystem.dto.Solution;
import com.studsystem.interfaces.repository.SolutionFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SolutionFirebaseRepositoryImpl implements SolutionFirebaseRepository {
    @Override
    public boolean save(Solution object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Solution get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
