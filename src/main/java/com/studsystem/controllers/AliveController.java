package com.studsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AliveController {

    @GetMapping("/")
    public String getUploadView(Model model) {
        model.addAttribute("message", "The application is alive!");
        return "index";
    }

}
