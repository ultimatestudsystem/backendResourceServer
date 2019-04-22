package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.StudyGroupValidationService;
import org.springframework.stereotype.Service;

@Service
public class StudyGroupValidationServiceImpl extends ValidationServiceImpl implements StudyGroupValidationService {
    @Override
    public String isGroupIdentifierValid(String studyGroupIdentifier) {
        return "";
    }
}
