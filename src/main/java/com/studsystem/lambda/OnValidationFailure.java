package com.studsystem.lambda;

@FunctionalInterface
public interface OnValidationFailure {
    void OnFailure(Object context, String validationMessage);
}
