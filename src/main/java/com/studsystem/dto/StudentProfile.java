package com.studsystem.dto;

import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;

public class StudentProfile extends UserProfile {

    public static StudentProfile getInstance() {
        return new StudentProfile();
    }

    private String additionalInfo;
    private float averageScore;
    private String groupKey;

    private StudentProfile() {
        super();
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public StudentProfile setAdditionalInfo(String additionalInfo, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.additionalInfo = additionalInfo;
        onValid(profileValidationService.isAdditionalInfoValid(getAdditionalInfo()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public StudentProfile setAverageScore(float averageScore, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.averageScore = averageScore;
        onValid(profileValidationService.isAverageScoreValid(averageScore), lambdaSuccess, lambdaFailure);
        return this;
    }

    public StudentProfile setGroupKey(String groupKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.groupKey = groupKey;
        validateKey(profileValidationService, getGroupKey(), "groups", lambdaSuccess, lambdaFailure);
        return this;
    }
}
