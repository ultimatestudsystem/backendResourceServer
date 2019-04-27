package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.StudyGroupValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupValidationServiceImpl extends ValidationServiceImpl implements StudyGroupValidationService {
    @Override
    public String isStudentKeysValid(List<String> studentKeys) {
        if (studentKeys == null) {
            return "";
        } else {
            return "Given list of student keys is null";
        }
    }
}
