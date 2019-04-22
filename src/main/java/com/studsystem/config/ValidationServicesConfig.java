package com.studsystem.config;

import com.studsystem.interfaces.validation.ValidationService;
import com.studsystem.interfaces.validation.*;
import com.studsystem.services.validation.ValidationServiceImpl;
import com.studsystem.services.validation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationServicesConfig {

    @Bean
    public ValidationService validationService() {
        return new ValidationServiceImpl();
    }

    @Bean
    public CourseValidationService courseValidationService() {
        return new CourseValidationServiceImpl();
    }

    @Bean
    public MessagesValidationService messagesValidationService() {
        return new MessagesValidationServiceImpl();
    }

    @Bean
    public ProfileValidationService profileValidationService() {
        return new ProfileValidationServiceImpl();
    }

    @Bean
    public SolutionValidationService solutionValidationService() {
        return new SolutionValidationServiceImpl();
    }

    @Bean
    public StudyGroupValidationService studyGroupValidationService() {
        return new StudyGroupValidationServiceImpl();
    }

    @Bean
    public TaskValidationService taskValidationService() {
        return new TaskValidationServiceImpl();
    }

}
