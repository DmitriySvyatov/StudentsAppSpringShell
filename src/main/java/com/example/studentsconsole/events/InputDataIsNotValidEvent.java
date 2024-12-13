package com.example.studentsconsole.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class InputDataIsNotValidEvent extends ApplicationEvent {

    public InputDataIsNotValidEvent(Object source) {
        super(source);
    }
}
