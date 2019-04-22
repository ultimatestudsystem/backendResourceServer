package com.studsystem.interfaces.validation;

public interface CourseValidationService extends ValidationService {
    String isStartDateValid(String startDate, String endDate);
    String isEndDateValid(String endDate, String StartDate);
    String isSubjectNameValid(String subjectName);
}
