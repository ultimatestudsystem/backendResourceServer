package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.Solution;
import com.studsystem.interfaces.repository.SolutionFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SolutionFirebaseRepositoryImpl implements SolutionFirebaseRepository {
    @Override
    public boolean save(Solution object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Solution> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Solution> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}
