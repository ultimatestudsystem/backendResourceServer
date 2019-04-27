package com.studsystem.services;

import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.ProfessorProfile;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.ProfessorsManagementService;
import com.studsystem.interfaces.repository.ProfessorProfileFirebaseRepository;
import com.studsystem.interfaces.repository.TaskFirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorsManagementServiceImpl implements ProfessorsManagementService {

    @Override
    public boolean addProfessorProfileToUserProfile(UserProfile up, ProfessorProfile pp) {
        FirebaseDatabase.getInstance().getReference("professors").child(up.getKey()).child("additional_info")
            .setValueAsync(pp.getAdditionalInfo());
        return true;
    }
}
