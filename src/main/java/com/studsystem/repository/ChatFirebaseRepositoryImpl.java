package com.studsystem.repository;


import com.studsystem.dto.Chat;
import com.studsystem.interfaces.repository.ChatFirebaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ChatFirebaseRepositoryImpl implements ChatFirebaseRepository {

    @Override
    public boolean save(Chat object) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Chat get(String key) {
        throw new RuntimeException("Not implemented yet");    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");    }

}
