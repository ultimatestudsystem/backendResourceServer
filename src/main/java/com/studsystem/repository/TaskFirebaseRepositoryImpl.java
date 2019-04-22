package com.studsystem.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.studsystem.dto.Task;
import com.studsystem.interfaces.repository.TaskFirebaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class TaskFirebaseRepositoryImpl implements TaskFirebaseRepository {
    @Override
    public boolean save(Task task) throws InterruptedException {
        AtomicBoolean result = new AtomicBoolean(true);
        DatabaseReference tasksReference = FirebaseDatabase.getInstance().getReference("tasks/" + task.getCourseKey());
        DatabaseReference newTaskReference = tasksReference.push();
        CountDownLatch cdl = new CountDownLatch(7);
        DatabaseReference.CompletionListener cl = (error, ref) -> {
            if (error == null) {
                result.set(false);
                cdl.countDown();
            }
        };
        newTaskReference.child("description").setValue(task.getDescription(), cl);
        newTaskReference.child("expiration_date").setValue(task.getExpirationDate(), cl);
        newTaskReference.child("last_updating_date").setValue(task.getLastUpdatingDate(), cl);
        newTaskReference.child("max_tries_num").setValue(task.getMaxTriesNum(), cl);
        newTaskReference.child("name").setValue(task.getName(), cl);
        newTaskReference.child("task_file_link").setValue(task.getTaskFileLink(), cl);
        newTaskReference.child("uploading_date").setValue(task.getUploadingDate(), cl);
        cdl.await();
        return result.get();
    }

    @Override
    public Optional<Task> get(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public boolean delete(String key) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public Optional<Task> mapFromDataSnapshot(DataSnapshot dataSnapshot) {
        throw new RuntimeException("Not implemented yet");
    }

}
