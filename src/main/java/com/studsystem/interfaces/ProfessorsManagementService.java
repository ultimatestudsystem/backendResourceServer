package com.studsystem.interfaces;

import com.studsystem.dto.*;
import com.studsystem.enums.SolutionState;

import java.util.List;
import java.util.Optional;

public interface ProfessorsManagementService {
    boolean addProfessorProfileToUserProfile(UserProfile up, ProfessorProfile pp);
}
