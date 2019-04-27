package com.studsystem.dto;

import com.studsystem.enums.SolutionState;
import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.SolutionValidationService;

public class Solution extends DTO {

    public static Solution getInstance() {
        return new Solution();
    }

    private String key;
    private String courseKey;
    private String userKey;
    private String taskKey;
    private String checkingDate;
    private String commentary;
    private float score;
    private SolutionState status;
    private String solutionFileLink;
    private String uploadingDate;

    private SolutionValidationService solutionValidationService;

    private Solution() {
        solutionValidationService = DTOUtilities.getValidationServiceOf(SolutionValidationService.class);
    }

    public String getKey() {
        return key;
    }

    public String getCourseKey() {
        return courseKey;
    }

    public String getUserKey() {
        return userKey;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public String getCheckingDate() {
        return checkingDate;
    }

    public String getCommentary() {
        return commentary;
    }

    public float getScore() {
        return score;
    }

    public String getSolutionFileLink() {
        return solutionFileLink;
    }

    public String getUploadingDate() {
        return uploadingDate;
    }

    public SolutionState getStatus() {
        return status;
    }

    public Solution setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        onValid(solutionValidationService.isSolutionKeyValid(getKey(), getCourseKey(), getUserKey(),
                getTaskKey()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setCourseKey(String courseKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.courseKey = courseKey;
        validateKey(solutionValidationService, getCourseKey(), "courses", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setUserKey(String userKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.userKey = userKey;
        validateKey(solutionValidationService, getUserKey(), "users", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setTaskKey(String taskKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.taskKey = taskKey;
        onValid(solutionValidationService.isTaskKeyValid(getTaskKey(), getCourseKey()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setCheckingDate(String checkingDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.checkingDate = checkingDate;
        onValid(solutionValidationService.isCheckingDateValid(getCheckingDate(), getUploadingDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setCommentary(String commentary, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.commentary = commentary;
        onValid(solutionValidationService.isCommentaryValid(commentary), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setScore(float score, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.score = score;
        onValid(solutionValidationService.isScoreValid(score), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setStatus(String status, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        try {
            this.status = SolutionState.valueOf(status);
        } catch (RuntimeException r) {
            if (lambdaFailure != null) {
                lambdaFailure.OnFailure(this, "invalid status of solution");
            }
        }
        if (lambdaFailure != null) {
            lambdaSuccess.OnSuccess(this);
        }
        return this;
    }

    public Solution setSolutionFileLink(String solutionFileLink, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.solutionFileLink = solutionFileLink;
        onValid(solutionValidationService.isSolutionFileLinkValid(getSolutionFileLink()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Solution setUploadingDate(String uploadingDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.uploadingDate = uploadingDate;
        onValid(solutionValidationService.isUploadingDateValid(getUploadingDate(), getCheckingDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    @Override
    public String toString() {
        return String.format("{Key:%s, CourseKey:%s, TaskKey:%s, UserKey:%s}", getKey(), getCourseKey(), getTaskKey(), getUserKey());
    }
}
