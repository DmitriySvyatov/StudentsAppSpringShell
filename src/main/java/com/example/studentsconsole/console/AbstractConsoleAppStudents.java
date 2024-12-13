package com.example.studentsconsole.console;

import com.example.studentsconsole.events.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import com.example.studentsconsole.dto.Student;
import com.example.studentsconsole.service.FileParserService;
import com.example.studentsconsole.service.StudentService;
import com.example.studentsconsole.service.StudentValidatorService;

import java.io.IOException;

public class AbstractConsoleAppStudents {
    @Value("${file.path}")
    private String fileName;

    private final StudentService studentService;
    private final StudentValidatorService validator;
    private final FileParserService fileParserService;
    private final ApplicationEventPublisher eventPublisher;

    public AbstractConsoleAppStudents(StudentService studentService, StudentValidatorService validator, FileParserService fileParserService, ApplicationEventPublisher eventPublisher) {
        this.studentService = studentService;
        this.validator = validator;
        this.fileParserService = fileParserService;
        this.eventPublisher = eventPublisher;
    }

    @ShellMethod(value = "Add student to list", key = "add")
    public void addStudent(@ShellOption(value = "-f") String firstName,
                           @ShellOption(value = "-l") String lastName,
                           @ShellOption(value = "-a") int age) {
        if (validator.isValid(firstName, lastName, age)) {
            Student student = new Student(firstName, lastName, age);
            studentService.addStudent(student);
        } else {
            eventPublisher.publishEvent(new InputDataIsNotValidEvent(this));
        }
    }

    @ShellMethod(value = "Remove student by id from students list", key = "remove")
    @ShellMethodAvailability("isEmpty")
    public void deleteStudent(Integer id) {
        if (studentService.getAllStudents().contains(id)) {
            studentService.removeStudent(id);
            eventPublisher.publishEvent(new StudentRemovedEvent(this, id));
        } else {
            eventPublisher.publishEvent(new StudentByIdNotFoundEvent(this, id));
        }
    }

    @ShellMethod(value = "Show all students", key = "show")
    @ShellMethodAvailability("isEmpty")
    public void showStudents() {
        studentService.getAllStudents().forEach(System.out::println);
    }

    @ShellMethod(value = "Clear all students", key = "clear-all")
    @ShellMethodAvailability("isEmpty")
    public void clearStudentList() {
        studentService.clearStudents();
        eventPublisher.publishEvent(new AllStudentsRemoveEvent(this));
    }

    @ShellMethod(value = "Parse students from file", key = "parse")
    public void parseFromFile() {
        try {
            fileParserService.parseFile(fileName, studentService);
            eventPublisher.publishEvent(new StudentParsingSuccessfulEvent(this));
        } catch (IOException e) {
            eventPublisher.publishEvent(new StudentParsingUnsuccessfulEvent(this));
        }
    }

    public Availability isEmpty() {
        if (studentService.getAllStudents().isEmpty()) {
            return Availability.unavailable("Students list is empty");
        } else {
            return Availability.available();
        }
    }

}
