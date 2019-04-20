package com.studsystem.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studsystem.interfaces.HelperService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class HelperServiceImpl implements HelperService {

    @Override
    public String getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
