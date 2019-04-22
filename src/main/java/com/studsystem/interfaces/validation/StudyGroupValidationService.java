package com.studsystem.interfaces.validation;

public interface StudyGroupValidationService extends ValidationService {
    String isGroupIdentifierValid(String studyGroupIdentifier);
}
