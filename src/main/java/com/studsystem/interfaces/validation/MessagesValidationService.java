package com.studsystem.interfaces.validation;

public interface MessagesValidationService extends ValidationService {
    String isContentValid(String content);
    String isIsMessageKeyExists(String key, String chatKey);
}
