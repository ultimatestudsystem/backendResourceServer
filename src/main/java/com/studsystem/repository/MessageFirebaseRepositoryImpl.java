package com.studsystem.repository;

import com.studsystem.dto.Message;
import com.studsystem.interfaces.repository.MessageFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MessageFirebaseRepositoryImpl implements MessageFirebaseRepository {
    @Override
    public boolean save(Message object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Message get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }
}
