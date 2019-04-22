package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.CourseValidationService;
import org.springframework.stereotype.Service;

@Service
public class CourseValidationServiceImpl extends ValidationServiceImpl implements CourseValidationService {
    @Override
    public String isStartDateValid(String startDate, String endDate) {
        return "";
    }

    @Override
    public String isEndDateValid(String endDate, String StartDate) {
        return "";
    }

    @Override
    public String isSubjectNameValid(String subjectName) {
        return "";
    }
}
