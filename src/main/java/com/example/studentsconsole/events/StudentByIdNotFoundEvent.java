package com.example.studentsconsole.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class StudentByIdNotFoundEvent extends ApplicationEvent {
    private final Integer id;

    public StudentByIdNotFoundEvent(Object source, Integer id) {
        super(source);
        this.id = id;
    }
}
