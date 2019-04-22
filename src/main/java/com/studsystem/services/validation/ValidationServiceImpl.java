package com.studsystem.services.validation;

import com.studsystem.interfaces.validation.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public String isKeyExists(String key, String path) {
        return "";
    }
}
