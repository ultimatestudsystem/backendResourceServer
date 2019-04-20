package com.studsystem.interfaces.validation;

import com.studsystem.interfaces.ValidationService;

public interface MessagesValidationService extends ValidationService {
    String isContentValid(String content);
    String isIsMessageKeyExists(String key, String chatKey);
}
