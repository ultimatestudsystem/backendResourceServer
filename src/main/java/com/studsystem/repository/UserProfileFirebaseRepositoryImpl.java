package com.studsystem.repository;

import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.repository.UserProfileFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileFirebaseRepositoryImpl implements UserProfileFirebaseRepository {
    @Override
    public boolean save(UserProfile object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public UserProfile get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
