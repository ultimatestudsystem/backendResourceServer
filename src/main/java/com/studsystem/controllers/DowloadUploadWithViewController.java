package com.studsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DowloadUploadWithViewController {

    @GetMapping("/upload")
    public String getUploadView(Model model) {
        model.addAttribute("message", "Welcome aboard!");
        return "index";
    }

}
