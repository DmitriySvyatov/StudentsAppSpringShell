package com.example.studentsconsole.events;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.example.studentsconsole.dto.Student;

@Getter
public class StudentAddedEvent extends ApplicationEvent {
    private final Student student;

    public StudentAddedEvent(Object source,Student student) {
        super(source);
        this.student=student;
    }

}
