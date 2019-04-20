package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.TaskValidationService;
import com.studsystem.services.ValidationServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TaskValidationServiceImpl extends ValidationServiceImpl implements TaskValidationService {
    @Override
    public String isExpirationDateValid(String expirationDate, String uploadingDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isLastUpdatingDateValid(String lastUpdatingDate, String uploadingDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isUploadingDateValid(String uploadingDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isTaskFileLinkValid(String taskFileLink) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isDescriptionValid(String description) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isMaxTriesNumValid(int maxTriesNum) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isNameValid(String name) {
        throw new RuntimeException("Not yet implemented");
    }
}
