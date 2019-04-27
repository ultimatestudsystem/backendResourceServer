package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.StudyGroup;
import com.studsystem.interfaces.repository.StudyGroupFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class StudyGroupFirebaseRepositoryImpl implements StudyGroupFirebaseRepository {

    @Override
    public boolean save(StudyGroup group) {
        DatabaseReference studyGroupReference = FirebaseDatabase.getInstance().getReference("groups");
        for (String studentKey : group.getStudentKeys()) {
            studyGroupReference.child(group.getKey()).child(studentKey).setValueAsync(0);
        }
        return true;
    }

    @Override
    public Optional<StudyGroup> get(String key) {
        try {
            return isObjectWithPredicateExists("study_groups", studyGroup -> studyGroup.getKey().equals(key));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(String key) {
        FirebaseDatabase.getInstance().getReference("study_groups").child(key).setValueAsync(null);
        return true;
    }

    @Override
    public Optional<StudyGroup> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        StudyGroup result = StudyGroup.getInstance()
                .setKey(dataSnapshot.getKey(), null, null)
                .setStudentKeys(new ArrayList<>(), null, null);
        dataSnapshot.getChildren().forEach(data -> result.getStudentKeys().add(data.getKey()));
        return Optional.of(result);
    }

}
