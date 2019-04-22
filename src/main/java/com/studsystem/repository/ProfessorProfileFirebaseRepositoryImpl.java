package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.ProfessorProfile;
import com.studsystem.interfaces.repository.ProfessorProfileFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProfessorProfileFirebaseRepositoryImpl implements ProfessorProfileFirebaseRepository {
    @Override
    public boolean save(ProfessorProfile object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<ProfessorProfile> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<ProfessorProfile> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}
