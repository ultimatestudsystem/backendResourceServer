package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.SolutionValidationService;
import com.studsystem.services.ValidationServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SolutionValidationServiceImpl extends ValidationServiceImpl implements SolutionValidationService {
    @Override
    public String isSolutionKeyValid(String solutionKey, String courseKey, String userKey, String taskKey) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isTaskKeyValid(String taskKey, String courseKey) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isScoreValid(float score) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isSolutionFileLinkValid(String solutionFileLink) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isCommentaryValid(String commentary) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isCheckingDateValid(String checkingDate, String uploadingDate) {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public String isUploadingDateValid(String uploadingDate, String checkingDate) {
        throw new RuntimeException("Not yet implemented");
    }
}
