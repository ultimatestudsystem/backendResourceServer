package com.studsystem.interfaces.validation;

import com.studsystem.interfaces.ValidationService;

public interface TaskValidationService extends ValidationService {

    String isExpirationDateValid(String expirationDate, String uploadingDate);
    String isLastUpdatingDateValid(String lastUpdatingDate, String uploadingDate);
    String isUploadingDateValid(String uploadingDate);
    String isTaskFileLinkValid(String taskFileLink);
    String isDescriptionValid(String description);
    String isMaxTriesNumValid(int maxTriesNum);
    String isNameValid(String name);

}
