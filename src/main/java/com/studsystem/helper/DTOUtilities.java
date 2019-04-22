package com.studsystem.helper;

import com.studsystem.config.ValidationServicesConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DTOUtilities {
    public static <T> T getValidationServiceOf(Class<T> c) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ValidationServicesConfig.class);
        return ctx.getBean(c);
    }
}
