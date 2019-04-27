package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.StudyGroupValidationService;

import java.util.List;

public class StudyGroup extends DTO {

    public static StudyGroup getInstance() {
        return new StudyGroup();
    }

    private List<String> studentKeys;
    private String key;

    private StudyGroupValidationService studyGroupValidationService;

    private StudyGroup() {
        studyGroupValidationService = DTOUtilities.getValidationServiceOf(StudyGroupValidationService.class);
    }

    public String getKey() {
        return key;
    }
    public List<String> getStudentKeys() {
        return studentKeys;
    }


    public StudyGroup setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        validateKey(studyGroupValidationService, getKey(), "study_groups", lambdaSuccess, lambdaFailure);
        return this;
    }

    public StudyGroup setStudentKeys(List<String> studentKeys, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.studentKeys = studentKeys;
        onValid(studyGroupValidationService.isStudentKeysValid(getStudentKeys()), lambdaSuccess, lambdaFailure);
        return this;
    }


}
