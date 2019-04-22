package com.studsystem.helper;

import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.ValidationService;

public class DTO {

    protected void validateKey(ValidationService validationService, String key, String path, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        onValid(validationService.isKeyExists(key, path), lambdaSuccess, lambdaFailure);
    }

    protected void onValid(String validationResult, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        if (validationResult.isEmpty()) {
            if (lambdaSuccess != null) {
                lambdaSuccess.OnSuccess(this);
            }
        } else {
            if (lambdaFailure != null) {
                lambdaFailure.OnFailure(this, validationResult);
            }
        }
    }
}
