package com.studsystem.services;

import com.studsystem.interfaces.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public String isKeyExists(String key, String path) {
        throw new RuntimeException("Not yet implemented");
    }
}
