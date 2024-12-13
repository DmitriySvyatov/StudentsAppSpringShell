package com.example.studentsconsole.listeners;

import com.example.studentsconsole.events.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.text.MessageFormat;

@Component
public class StudentEventListener {

    @EventListener
    public void handleStudentAdded(StudentAddedEvent event) {
        System.out.println(MessageFormat.format("{0} add to list", event.getStudent()));
    }

    @EventListener
    public void handleStudentRemoved(StudentRemovedEvent event) {
        System.out.println(MessageFormat.format("Students with id : {0} - delete from list students", event.getId()));
    }

    @EventListener
    public void handleStudentCanNotRemoved(InputDataIsNotValidEvent event) {
        System.out.println("Input data not valid");
    }

    @EventListener
    public void handleStudentNotFoundById(StudentByIdNotFoundEvent event) {
        System.out.println(MessageFormat.format("Students with id : {0} - not found", event.getId()));
    }

    @EventListener
    public void handleParsingSuccessful(StudentParsingSuccessfulEvent event) {
        System.out.println("Students loaded from file");
    }

    @EventListener
    public void handleParsingUnsuccessful(StudentParsingUnsuccessfulEvent event) {
        System.out.println("Error loading data");
    }

    @EventListener
    public void handleRemovedAllStudents(AllStudentsRemoveEvent event) {
        System.out.println("Student list cleared");
    }





}
