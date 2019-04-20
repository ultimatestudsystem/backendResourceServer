package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.CourseValidationService;
import com.studsystem.services.ValidationServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CourseValidationServiceImpl extends ValidationServiceImpl implements CourseValidationService {
    @Override
    public String isStartDateValid(String startDate, String endDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isEndDateValid(String endDate, String StartDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isSubjectNameValid(String subjectName) {
        throw new RuntimeException("Not yet implemented");
    }
}
