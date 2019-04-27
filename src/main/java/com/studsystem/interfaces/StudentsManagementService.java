package com.studsystem.interfaces;

import com.studsystem.dto.*;

import java.util.List;
import java.util.Optional;

public interface StudentsManagementService {
    boolean addStudentProfileToUserProfile(UserProfile up, StudentProfile sp);
}
