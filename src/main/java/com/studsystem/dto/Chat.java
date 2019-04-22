package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.ValidationService;

public class Chat extends DTO {

    public static Chat getInstance() {
        return new Chat();
    }

    private String key;
    private String professorKey;
    private String studentKey;

    private ValidationService validationService;

    private Chat() {
        validationService = DTOUtilities.getValidationServiceOf(ValidationService.class);
    }

    public String getKey() {
        return key;
    }

    public String getProfessorKey() {
        return professorKey;
    }

    public String getStudentKey() {
        return studentKey;
    }

    public Chat setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        validateKey(validationService, getKey(), "chats", lambdaSuccess, lambdaFailure);
        return this;
    }

    private Chat setProfessorKey(String professorKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.professorKey = professorKey;
        validateKey(validationService, getProfessorKey(), "professors", lambdaSuccess, lambdaFailure);
        return this;
    }

    private Chat setStudentKey(String studentKey, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.studentKey = studentKey;
        validateKey(validationService, getStudentKey(), "students", lambdaSuccess, lambdaFailure);
        return this;
    }

}
