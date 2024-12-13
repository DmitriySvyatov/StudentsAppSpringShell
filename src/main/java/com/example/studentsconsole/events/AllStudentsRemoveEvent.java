package com.example.studentsconsole.events;

import org.springframework.context.ApplicationEvent;

public class AllStudentsRemoveEvent extends ApplicationEvent {
    public AllStudentsRemoveEvent(Object source) {
        super(source);
    }
}
