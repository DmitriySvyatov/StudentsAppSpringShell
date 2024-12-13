package com.example.studentsconsole.service;

import org.springframework.stereotype.Component;

@Component
public class StudentValidatorService {
    private final String nameRegex = "^[A-Za-z]+$";

    public boolean isValid(String firstName, String lastName, int age) {
        return firstName.matches(nameRegex) && lastName.matches(nameRegex) && age > 0;
    }
}