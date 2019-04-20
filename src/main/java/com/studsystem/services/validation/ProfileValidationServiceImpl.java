package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.ProfileValidationService;
import com.studsystem.services.ValidationServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProfileValidationServiceImpl extends ValidationServiceImpl implements ProfileValidationService {

    @Override
    public String isEmailValid(String email) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isBirthDateValid(String birthDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isFirstNameValid(String firstName) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isLastNameValid(String lastName) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isMiddleNameValid(String middleName) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isPhoneValid(String phone) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isPhotoURLValid(String photo) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isAdditionalInfoValid(String additionalInfo) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isAverageScoreValid(float averageScore) {
        throw new RuntimeException("Not yet implemented");
    }
}
