package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.studsystem.dto.Message;
import com.studsystem.interfaces.repository.MessageFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MessageFirebaseRepositoryImpl implements MessageFirebaseRepository {
    @Override
    public boolean save(Message object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Message> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Message> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}
