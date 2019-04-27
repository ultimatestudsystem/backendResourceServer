package com.studsystem.services.validation;

import com.google.firebase.database.*;
import com.studsystem.helper.DTO;
import com.studsystem.interfaces.repository.FirebaseRepository;
import com.studsystem.interfaces.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public String isKeyExists(String key, String path) {
        AtomicBoolean result = new AtomicBoolean(false);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                snapshot.getChildren().forEach(dataSnapshot -> {
                    if (dataSnapshot.getKey().equals(key)) {
                        result.set(true);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Logger.getLogger(this.getClass().getName())
                        .log(Level.SEVERE, error.getMessage() + "\nDetails:\n" + error.getDetails());
            }
        });
        return result.get() ? "" : String.format("The key %s in not found on path %s", key, path);
    }
}
