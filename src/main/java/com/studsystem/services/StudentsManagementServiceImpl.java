package com.studsystem.services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.*;
import com.studsystem.interfaces.StudentsManagementService;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsManagementServiceImpl implements StudentsManagementService {
    @Override
    public boolean addStudentProfileToUserProfile(UserProfile up, StudentProfile sp) {
        DatabaseReference newStudentProfileReference = FirebaseDatabase.getInstance().getReference("students")
                .child(up.getKey());
        newStudentProfileReference.child("additional_info").setValueAsync(sp.getAdditionalInfo());
        newStudentProfileReference.child("average_score").setValueAsync(sp.getAverageScore());
        newStudentProfileReference.child("group_id").setValueAsync(sp.getGroupKey());
        return true;
    }
}
