package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.repository.UserProfileFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserProfileFirebaseRepositoryImpl implements UserProfileFirebaseRepository {
    @Override
    public boolean save(UserProfile object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<UserProfile> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<UserProfile> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}