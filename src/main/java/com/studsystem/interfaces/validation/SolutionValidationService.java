package com.studsystem.interfaces.validation;

public interface SolutionValidationService extends ValidationService {

    String isSolutionKeyValid(String solutionKey, String courseKey, String userKey, String taskKey);
    String isTaskKeyValid(String taskKey, String courseKey);
    String isScoreValid(float score);
    String isSolutionFileLinkValid(String solutionFileLink);
    String isCommentaryValid(String commentary);

    String isCheckingDateValid(String checkingDate, String uploadingDate);
    String isUploadingDateValid(String uploadingDate, String checkingDate);

}
