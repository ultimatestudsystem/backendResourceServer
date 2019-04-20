package com.studsystem.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface HelperService {
    String getCurrentTimestamp();
    ObjectMapper getObjectMapper();
}
