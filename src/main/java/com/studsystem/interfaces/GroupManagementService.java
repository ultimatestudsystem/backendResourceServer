package com.studsystem.interfaces;

import com.studsystem.dto.StudyGroup;
import com.studsystem.dto.UserProfile;

import java.util.List;

public interface GroupManagementService {
    boolean createGroup(StudyGroup group);
    List<StudyGroup> getAllGroups();
    boolean addToGroup(UserProfile user, StudyGroup group);
}
