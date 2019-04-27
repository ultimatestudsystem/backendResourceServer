package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.TaskValidationService;

public class Task extends DTO {

    public static Task getInstance() {
        return new Task();
    }

    private String key;
    private String courseKey;
    private String description;
    private String expirationDate;
    private String lastUpdatingDate;
    private int maxTriesNum;
    private String name;
    private String taskFileLink;
    private String uploadingDate;

    private TaskValidationService taskValidationService;

    private Task() {
        taskValidationService = DTOUtilities.getValidationServiceOf(TaskValidationService.class);
    }

    public String getKey() {
        return key;
    }

    public String getCourseKey() {
        return courseKey;
    }

    public String getDescription() {
        return description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getLastUpdatingDate() {
        return lastUpdatingDate;
    }

    public int getMaxTriesNum() {
        return maxTriesNum;
    }

    public String getName() {
        return name;
    }

    public String getUploadingDate() {
        return uploadingDate;
    }

    public String getTaskFileLink() {
        return taskFileLink;
    }

    public Task setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        validateKey(taskValidationService, getKey(), "tasks/" + getCourseKey(), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setCourseKey(String courseKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.courseKey = courseKey;
        validateKey(taskValidationService, getCourseKey(), "courses", lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setDescription(String description, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.description = description;
        onValid(taskValidationService.isDescriptionValid(getDescription()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setExpirationDate(String expirationDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.expirationDate = expirationDate;
        onValid(taskValidationService.isExpirationDateValid(getExpirationDate(), getUploadingDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setLastUpdatingDate(String lastUpdatingDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.lastUpdatingDate = lastUpdatingDate;
        onValid(taskValidationService.isLastUpdatingDateValid(getLastUpdatingDate(), getUploadingDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setMaxTriesNum(int maxTriesNum, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.maxTriesNum = maxTriesNum;
        onValid(taskValidationService.isMaxTriesNumValid(getMaxTriesNum()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setName(String name, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.name = name;
        onValid(taskValidationService.isNameValid(getName()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setTaskFileLink(String taskFileLink, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.taskFileLink = taskFileLink;
        onValid(taskValidationService.isTaskFileLinkValid(getTaskFileLink()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public Task setUploadingDate(String uploadingDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.uploadingDate = uploadingDate;
        onValid(taskValidationService.isUploadingDateValid(getUploadingDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    @Override
    public String toString() {
        return String.format("{Key:%s, CourseKey:%s}", getKey(), getCourseKey());
    }
}
