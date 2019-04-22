package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.TaskValidationService;
import org.springframework.stereotype.Service;

@Service
public class TaskValidationServiceImpl extends ValidationServiceImpl implements TaskValidationService {
    @Override
    public String isExpirationDateValid(String expirationDate, String uploadingDate) {
        return "";
    }

    @Override
    public String isLastUpdatingDateValid(String lastUpdatingDate, String uploadingDate) {
        return "";
    }

    @Override
    public String isUploadingDateValid(String uploadingDate) {
        return "";
    }

    @Override
    public String isTaskFileLinkValid(String taskFileLink) {
        return "";
    }

    @Override
    public String isDescriptionValid(String description) {
        return "";
    }

    @Override
    public String isMaxTriesNumValid(int maxTriesNum) {
        return "";
    }

    @Override
    public String isNameValid(String name) {
        return "";
    }
}
