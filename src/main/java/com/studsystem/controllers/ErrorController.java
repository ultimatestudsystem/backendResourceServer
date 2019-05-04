package com.studsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController  {

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Logger.getLogger(this.getClass().getName())
                .log(Level.SEVERE, request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString());
        Logger.getLogger(this.getClass().getName())
                .log(Level.SEVERE, ((Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)).getMessage());

        if (status != null) {

            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("message", "The page you are looking for is not found");
            } else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("message", "An internal error occurred. Our engineers is going after that.");
            }

            model.addAttribute("statusCode", statusCode);
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
