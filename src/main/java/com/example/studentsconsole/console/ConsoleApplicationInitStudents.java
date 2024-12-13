package com.example.studentsconsole.console;

import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.standard.ShellComponent;
import com.example.studentsconsole.service.FileParserService;
import com.example.studentsconsole.service.StudentService;
import com.example.studentsconsole.service.StudentValidatorService;

@ShellComponent
@Profile("init")
public class ConsoleApplicationInitStudents extends AbstractConsoleAppStudents {

    public ConsoleApplicationInitStudents(StudentService studentService, StudentValidatorService validator, FileParserService fileParserService, ApplicationEventPublisher eventPublisher) {
        super(studentService, validator, fileParserService, eventPublisher);
    }

    @PostConstruct
    public void initConsole() {
        parseFromFile();
    }
}
