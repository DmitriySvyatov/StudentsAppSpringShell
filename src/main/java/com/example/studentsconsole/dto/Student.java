package com.example.studentsconsole.dto;

import lombok.*;

@Data
@Setter
@Getter
public class Student {
    private static int counterId = 0;
    private Integer id;
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.id = ++counterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


}
