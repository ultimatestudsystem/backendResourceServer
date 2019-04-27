package com.studsystem.services;

import com.studsystem.interfaces.HelperService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class HelperServiceImpl implements HelperService {

    @Override
    public String getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

}
