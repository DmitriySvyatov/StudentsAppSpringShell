package com.example.studentsconsole.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentRemovedEvent extends ApplicationEvent {
    private final Integer id;

    public StudentRemovedEvent(Object source, Integer id) {
        super(source);
        this.id = id;
    }
}
