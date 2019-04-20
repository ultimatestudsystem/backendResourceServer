package com.studsystem.interfaces.validation;

import com.studsystem.interfaces.ValidationService;

public interface CourseValidationService extends ValidationService {
    String isStartDateValid(String startDate, String endDate);
    String isEndDateValid(String endDate, String StartDate);
    String isSubjectNameValid(String subjectName);
}
