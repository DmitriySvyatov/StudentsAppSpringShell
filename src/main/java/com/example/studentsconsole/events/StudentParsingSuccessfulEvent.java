package com.example.studentsconsole.events;

import org.springframework.context.ApplicationEvent;

public class StudentParsingSuccessfulEvent extends ApplicationEvent {
    public StudentParsingSuccessfulEvent(Object source) {
        super(source);
    }
}
