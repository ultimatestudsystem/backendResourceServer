package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.StudyGroup;
import com.studsystem.interfaces.repository.StudyGroupFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class StudyGroupFirebaseRepositoryImpl implements StudyGroupFirebaseRepository {
    @Override
    public boolean save(StudyGroup group) {
//        DatabaseReference studyGroupReference = FirebaseDatabase.getInstance().getReference("groups");
//        DatabaseReference newGroupReference = studyGroupReference.push();
//        AtomicBoolean result = new AtomicBoolean(true);
//        newGroupReference.child("group_identifier").setValue(group.getGroupIdentifier(), (error, ref) -> result.set(error != null));
//        return result.get();
        return false;
    }

    @Override
    public Optional<StudyGroup> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<StudyGroup> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}
