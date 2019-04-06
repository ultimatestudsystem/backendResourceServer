package com.studsystem.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.*;
import com.studsystem.services.FirebaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FirebaseUserController {

    @Autowired
    private FirebaseUserService firebaseUserService;

    @GetMapping("/create-user")
    public ResponseEntity createUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String type) throws FirebaseAuthException {

        firebaseUserService.createUser(email, password, type);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete-user")
    public ResponseEntity deleteUser(@RequestParam String uid) throws FirebaseAuthException {
        FirebaseAuth.getInstance().deleteUser(uid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/create-group")
    public ResponseEntity createGroup(@RequestParam String groupName) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("groups");
        final Boolean[] isUnique = {true};
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot data: children) {
                    if (data.hasChild("name") ){
                        Object name = data.child("name").getValue();
                        if (name.toString().equals(groupName)){
                            isUnique[0] = false;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.toString());
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isUnique[0]) {
            reference = reference.push();
            String groupKey = reference.getKey();
            System.out.println(groupKey);
            Map<String, String> attr = new HashMap<>();
            attr.put("name", groupName);
            reference.setValueAsync(attr);
            return ResponseEntity.ok().build();
        }else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/get-all-groups")
    public ResponseEntity getAllGroups () {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("groups");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot.getChildren().forEach(data -> {
                    String key = data.getKey();
                    if (data.hasChild("name") ){
                        Object name = data.child("name").getValue();
                        System.out.println(name.toString());
                    }
                    System.out.println(key);
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.toString());
            }
        });
        return ResponseEntity.ok().build();
    }

    @GetMapping("/add-to-group")
    public ResponseEntity addToGroup(@RequestParam String email, @RequestParam String groupUid) {

        return ResponseEntity.ok().build();
    }
}
