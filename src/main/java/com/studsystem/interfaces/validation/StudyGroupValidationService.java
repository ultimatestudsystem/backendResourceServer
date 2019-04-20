package com.studsystem.interfaces.validation;

import com.studsystem.interfaces.ValidationService;

public interface StudyGroupValidationService extends ValidationService {
    String isGroupIdentifierValid(String studyGroupIdentifier);
}
