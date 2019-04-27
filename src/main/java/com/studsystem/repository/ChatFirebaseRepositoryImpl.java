package com.studsystem.repository;


import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.Chat;
import com.studsystem.interfaces.repository.ChatFirebaseRepository;
import com.studsystem.interfaces.repository.FirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ChatFirebaseRepositoryImpl implements ChatFirebaseRepository {

    @Override
    public boolean save(Chat object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Chat> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Chat> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }
}

