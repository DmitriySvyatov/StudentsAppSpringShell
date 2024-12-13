package com.example.studentsconsole.service;


import com.example.studentsconsole.dto.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileParserService {
    public void parseFile(@Value("${file.path}") String fileName, StudentService studentService) throws IOException {
        try (BufferedReader buffer = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] arrString = line.split(";");
                if (arrString.length == 3) {
                    Student student = new Student(arrString[0], arrString[1], Integer.parseInt(arrString[2]));
                    studentService.addStudent(student);
                }
            }
        }
    }
}