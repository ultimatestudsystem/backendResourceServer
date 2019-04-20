package com.studsystem.lambda;

@FunctionalInterface
public interface OnValidationSuccess {
    void OnSuccess(Object context);
}
