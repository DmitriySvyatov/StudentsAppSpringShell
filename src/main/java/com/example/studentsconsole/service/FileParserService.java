package com.example.studentsconsole.service;


import com.example.studentsconsole.dto.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileParserService {
    @Value("${file.path}")
    private String filePath;

    public void parseFile( StudentService studentService) throws IOException {
        Resource resource=new ClassPathResource(filePath);
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
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