package com.studsystem.dto;

import com.studsystem.helper.DTO;
import com.studsystem.helper.DTOUtilities;
import com.studsystem.lambda.OnValidationFailure;
import com.studsystem.lambda.OnValidationSuccess;
import com.studsystem.interfaces.validation.ProfileValidationService;

public class UserProfile extends DTO {

    public static UserProfile getInstance() {
        return new UserProfile();
    }

    private String key;
    private String email;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String photo;
    private String firebaseUserId;
    private String role;

    protected ProfileValidationService profileValidationService;

    protected UserProfile() {
        profileValidationService = DTOUtilities.getValidationServiceOf(ProfileValidationService.class);
    }

    public String getKey() {
        return key;
    }
    public String getEmail() {
        return email;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getPhone() {
        return phone;
    }
    public String getPhoto() {
        return photo;
    }
    public String getRole() {
        return role;
    }

    public String getFirebaseUserId() {
        return firebaseUserId;
    }

    public UserProfile setKey(String key, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.key = key;
        validateKey(profileValidationService, getKey(), "users", lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setEmail(String email, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.email = email;
        onValid(profileValidationService.isEmailValid(getEmail()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setBirthDate(String birthDate, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.birthDate = birthDate;
        onValid(profileValidationService.isBirthDateValid(getBirthDate()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setFirstName(String firstName, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.firstName = firstName;
        onValid(profileValidationService.isFirstNameValid(getFirstName()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setLastName(String lastName, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.lastName = lastName;
        onValid(profileValidationService.isLastNameValid(getLastName()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setMiddleName(String middleName, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.middleName = middleName;
        onValid(profileValidationService.isMiddleNameValid(getMiddleName()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setPhone(String phone, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.phone = phone;
        onValid(profileValidationService.isPhoneValid(getPhone()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setPhoto(String photo, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.photo = photo;
        onValid(profileValidationService.isPhotoURLValid(getPhoto()), lambdaSuccess, lambdaFailure);
        return this;
    }

    public UserProfile setFirebaseUserId(String firebaseUserId) {
        this.firebaseUserId = firebaseUserId;
        return this;
    }

    public UserProfile setRole(String role, OnValidationSuccess lambdaSuccess, OnValidationFailure lambdaFailure) {
        this.role = role;
        onValid(profileValidationService.isRoleValid(getRole()), lambdaSuccess, lambdaFailure);
        return this;
    }
}
