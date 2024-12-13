package com.example.studentsconsole.events;

import org.springframework.context.ApplicationEvent;

public class StudentParsingUnsuccessfulEvent extends ApplicationEvent {
    public StudentParsingUnsuccessfulEvent(Object source) {
        super(source);
    }
}
