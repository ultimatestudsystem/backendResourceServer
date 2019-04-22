package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.MessagesValidationService;
import org.springframework.stereotype.Service;

@Service
public class MessagesValidationServiceImpl extends ValidationServiceImpl implements MessagesValidationService {
    @Override
    public String isContentValid(String content) {
        return "";
    }

    @Override
    public String isIsMessageKeyExists(String key, String chatKey) {
        return "";
    }
}
