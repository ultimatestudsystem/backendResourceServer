package com.studsystem.interfaces.repository;

import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface FirebaseRepository<T> {

    default Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    boolean save(T object) throws InterruptedException;
    Optional<T> get(String key);
    boolean delete(String key);
    Optional<T> mapFromDataSnapshot(DataSnapshot dataSnapshot);

    default Optional<T> isObjectWithPredicateExists(String path, Predicate<T> predicate) throws InterruptedException {
        AtomicReference<T> result = new AtomicReference<>();
        CountDownLatch cdl = new CountDownLatch(1);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Optional<T> optDTO = mapFromDataSnapshot(ds);
                    if (optDTO.isPresent()) {
                        T t = optDTO.get();
                        if (predicate.test(t)) {
                            result.set(t);
                            break;
                        }
                    } else {
                        getLogger().log(Level.SEVERE, "Optional of mapping " + optDTO.getClass().getName()
                                + " is not present. Mapping failed.");
                        break;
                    }
                }
                cdl.countDown();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                getLogger().log(Level.WARNING, error.getMessage().concat("\n==============\n").concat(error.getDetails()));
            }
        });
        cdl.await();
        return Optional.of(result.get());
    }

    default List<T> getObjectsAccordingToPredicate(String path, Predicate<T> predicate) throws InterruptedException {
        List<T> result = new ArrayList<>();
        CountDownLatch cdl = new CountDownLatch(1);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(path);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Optional<T> optDTO = mapFromDataSnapshot(ds);
                    if (optDTO.isPresent()) {
                        T t = optDTO.get();
                        if (predicate.test(t)){
                            result.add(t);
                        }
                    } else {
                        getLogger().log(Level.SEVERE, "Optional of mapping " + optDTO.getClass().getName()
                                + " is not present. Mapping failed.");
                        break;
                    }
                }
                cdl.countDown();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                getLogger().log(Level.WARNING, error.getMessage().concat("\n==============\n").concat(error.getDetails()));
            }
        });
        cdl.await();
        return result;
    }
}
