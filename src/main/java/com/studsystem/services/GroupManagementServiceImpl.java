package com.studsystem.services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.StudyGroup;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.GroupManagementService;
import com.studsystem.interfaces.repository.StudyGroupFirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupManagementServiceImpl implements GroupManagementService {

    @Autowired
    private StudyGroupFirebaseRepository studyGroupFirebaseRepository;

    @Override
    public boolean createGroup(StudyGroup group) {
        try {
            return studyGroupFirebaseRepository.save(group);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<StudyGroup> getAllGroups() {
        try {
            return studyGroupFirebaseRepository.getObjectsAccordingToPredicate("groups", (e) -> true);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addToGroup(UserProfile userProfile, StudyGroup studyGroup) {
        try {
            if (studyGroupFirebaseRepository.isObjectWithPredicateExists("study_groups",
                    (group) -> group.getStudentKeys().contains(userProfile.getKey())).isPresent()) {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        DatabaseReference studyGroupReference = FirebaseDatabase.getInstance().getReference("study_groups/" + studyGroup.getKey());
        Map<String, Object> userValues = new HashMap<>();
        userValues.put(userProfile.getKey(), 0);
        studyGroupReference.updateChildrenAsync(userValues);
        return true;
    }
}
