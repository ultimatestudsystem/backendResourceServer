package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.CourseValidationService;

public class Course extends DTO {

    public static Course getInstance() {
        return new Course();
    }

    private String key;
    private String endDate;
    private String groupKey;
    private String professorKey;
    private String startDate;

    private String subjectName;

    private CourseValidationService courseValidationService;

    private Course() {
        courseValidationService = DTOUtilities.getValidationServiceOf(CourseValidationService.class);
    }

    public String getKey() {
        return key;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public String getProfessorKey() {
        return professorKey;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Course setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        validateKey(courseValidationService, getKey(), "courses", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Course setEndDate(String endDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.endDate = endDate;
        onValid(courseValidationService.isEndDateValid(getEndDate(), getStartDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Course setGroupKey(String groupKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.groupKey = groupKey;
        validateKey(courseValidationService, getGroupKey(), "groups", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Course setProfessorKey(String professorKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.professorKey = professorKey;
        validateKey(courseValidationService, getProfessorKey(), "professors", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Course setStartDate(String startDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.startDate = startDate;
        onValid(courseValidationService.isStartDateValid(getStartDate(), getEndDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Course setSubjectName(String subjectName, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.subjectName = subjectName;
        onValid(courseValidationService.isSubjectNameValid(getSubjectName()), lambdaSuccess, lambdaFailure);
        return this;
    }
}
