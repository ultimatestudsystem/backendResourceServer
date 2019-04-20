package com.studsystem.dto;

import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;

public class ProfessorProfile extends UserProfile {

    private String additionalInfo;

    public static ProfessorProfile getInstance() {
        return new ProfessorProfile();
    }

    private ProfessorProfile() {
        super();
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public ProfessorProfile setAdditionalInfo(String additionalInfo, OnValidationSuccess lambdaSuccess,
                                              OnValidationFailure lambdaFailure) {
        this.additionalInfo = additionalInfo;
        onValid(profileValidationService.isAdditionalInfoValid(getAdditionalInfo()), lambdaSuccess, lambdaFailure);
        return this;
    }
}
