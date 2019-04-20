package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOValidation;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.StudyGroupValidationService;

public class StudyGroup extends DTO {

    public static StudyGroup getInstance() {
        return new StudyGroup();
    }

    private String groupIdentifier;
    private String key;

    private StudyGroupValidationService studyGroupValidationService;

    private StudyGroup() {
        studyGroupValidationService = DTOValidation.getValidationServiceOf(StudyGroupValidationService.class);
    }

    public String getKey() {
        return key;
    }

    public String getGroupIdentifier() {
        return groupIdentifier;
    }

    public StudyGroup setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        validateKey(studyGroupValidationService, getKey(), "study_groups", lambdaSuccess, lambdaFailure);
        return this;
    }

    public StudyGroup setGroupIdentifier(String groupIdentifier, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.groupIdentifier = groupIdentifier;
        onValid(studyGroupValidationService.isGroupIdentifierValid(getGroupIdentifier()), lambdaSuccess, lambdaFailure);
        return this;
    }
}
