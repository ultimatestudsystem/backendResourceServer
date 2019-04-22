package com.studsystem.services;

import com.studsystem.dto.StudyGroup;
import com.studsystem.dto.UserProfile;
import com.studsystem.interfaces.GroupManagementService;
import com.studsystem.interfaces.repository.StudyGroupFirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        }
        return false;
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

//        DatabaseReference studentsReference = FirebaseDatabase.getInstance().getReference("students");
//        DatabaseReference usersReference = FirebaseDatabase.getInstance().getReference("users");
//        DatabaseReference studyGroupReference = FirebaseDatabase.getInstance().getReference("study_groups");



//        CountDownLatch cdlForStudents = new CountDownLatch(1);
//        CountDownLatch cdlForUsers = new CountDownLatch(1);
//        CountDownLatch cdlForStudyGroups = new CountDownLatch(1);
//
//        AtomicReference<String> userProfileKey = new AtomicReference<>();
//        AtomicReference<String> studyGroupKey = new AtomicReference<>();
//
//        studyGroupReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                snapshot.getChildren().forEach(data -> {
//                    if (studyGroup.getGroupIdentifier().equals(data.child("group_identifier").toString())) {
//                        studyGroupKey.set(data.getKey());
//                    }
//                });
//                cdlForStudyGroups.countDown();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                System.err.println(error.toString());
//            }
//        });
//
//        try {
//            cdlForStudyGroups.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        if (studyGroupKey.get().isEmpty()) {
//            System.err.println("Study group key not found: " + studyGroup.getGroupIdentifier());
//            return false;
//        }
//
//        usersReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                snapshot.getChildren().forEach(data -> {
//                    if (data.child("email").toString().equals(userProfile.getEmail())) {
//                        userProfileKey.set(data.getKey());
//                    }
//                });
//                cdlForUsers.countDown();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                System.err.println(error.toString());
//            }
//        });
//
//        try {
//            cdlForUsers.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        if (userProfileKey.get().isEmpty()) {
//            System.err.println("User profile key not found: " + userProfile.getEmail());
//            return false;
//        }
//
//        studentsReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                dataSnapshot.getChildren().forEach(data -> {
//                    String studentKey = data.getKey();
//                    String userKey = userProfileKey.get();
//                    if (studentKey.equals(userKey)) {
//                        Map<String, String> attr = new HashMap<>();
//                        attr.put("groupID", studyGroupKey.get());
//                        studentsReference.setValueAsync(attr);
//                    }
//                });
//                cdlForStudents.countDown();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.err.println(databaseError.toString());
//            }
//        });
//
//        try {
//            cdlForStudents.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;

        throw new RuntimeException("Not yet implemented");
    }
}
