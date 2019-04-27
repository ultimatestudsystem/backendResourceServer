package com.studsystem.interfaces.validation;

public interface ProfileValidationService extends ValidationService {
    String isEmailValid(String email);
    String isBirthDateValid(String birthDate);
    String isFirstNameValid(String firstName);
    String isLastNameValid(String lastName);
    String isMiddleNameValid(String middleName);
    String isPhoneValid(String phone);
    String isPhotoURLValid(String photo);
    String isAdditionalInfoValid(String additionalInfo);
    String isAverageScoreValid(float averageScore);
    String isRoleValid(String role);
}
