package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.SolutionValidationService;
import org.springframework.stereotype.Service;

@Service
public class SolutionValidationServiceImpl extends ValidationServiceImpl implements SolutionValidationService {

    @Override
    public String isSolutionKeyValid(String solutionKey, String courseKey, String userKey, String taskKey) {
        return "";
    }

    @Override
    public String isTaskKeyValid(String taskKey, String courseKey) {
        return "";
    }

    @Override
    public String isScoreValid(float score) {
        return "";
    }

    @Override
    public String isSolutionFileLinkValid(String solutionFileLink) {
        return "";
    }

    @Override
    public String isCommentaryValid(String commentary) {
        return "";
    }

    @Override
    public String isCheckingDateValid(String checkingDate, String uploadingDate) {
        return "";
    }

    @Override
    public String isUploadingDateValid(String uploadingDate, String checkingDate) {
        return "";
    }
}
