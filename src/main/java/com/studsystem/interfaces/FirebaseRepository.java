package com.studsystem.interfaces;

public interface FirebaseRepository<T> {
    boolean save(T object);
    T get(String key);
    boolean delete(String key);
}
