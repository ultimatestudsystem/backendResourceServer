package com.studsystem.interfaces.validation;

import java.util.List;

public interface StudyGroupValidationService extends ValidationService {
    String isStudentKeysValid(List<String> studentKeys);
}
