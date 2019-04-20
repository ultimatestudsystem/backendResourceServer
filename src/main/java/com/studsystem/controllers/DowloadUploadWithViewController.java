package com.studsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DowloadUploadWithViewController {

    @GetMapping("/upload")
    public String getUploadView() {
        throw new RuntimeException("Not implemented yet");
    }

}
