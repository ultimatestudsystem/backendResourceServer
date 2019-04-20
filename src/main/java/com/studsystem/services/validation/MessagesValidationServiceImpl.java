package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.MessagesValidationService;
import com.studsystem.services.ValidationServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MessagesValidationServiceImpl extends ValidationServiceImpl implements MessagesValidationService {
    @Override
    public String isContentValid(String content) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isIsMessageKeyExists(String key, String chatKey) {
        throw new RuntimeException("Not yet implemented");
    }
}
