package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.ProfileValidationService;
import org.springframework.stereotype.Service;

@Service
public class ProfileValidationServiceImpl extends ValidationServiceImpl implements ProfileValidationService {

    @Override
    public String isEmailValid(String email) {
        return "";
    }

    @Override
    public String isBirthDateValid(String birthDate) {
        return "";
    }

    @Override
    public String isFirstNameValid(String firstName) {
        return "";
    }

    @Override
    public String isLastNameValid(String lastName) {
        return "";
    }

    @Override
    public String isMiddleNameValid(String middleName) {
        return "";
    }

    @Override
    public String isPhoneValid(String phone) {
        return "";
    }

    @Override
    public String isPhotoURLValid(String photo) {
        return "";
    }

    @Override
    public String isAdditionalInfoValid(String additionalInfo) {
        return "";
    }

    @Override
    public String isAverageScoreValid(float averageScore) {
        return "";
    }

    @Override
    public String isRoleValid(String role) {
        return "";
    }
}
