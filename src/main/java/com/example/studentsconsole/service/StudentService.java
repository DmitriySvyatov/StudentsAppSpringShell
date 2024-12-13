package com.example.studentsconsole.service;


import com.example.studentsconsole.dto.Student;
import com.example.studentsconsole.events.StudentAddedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class StudentService {
    private final Map<Integer, Student> students;
    private final ApplicationEventPublisher eventPublisher;

    public StudentService(ApplicationEventPublisher eventPublisher, Map<Integer, Student> students) {
        this.eventPublisher = eventPublisher;
        this.students = students;
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        eventPublisher.publishEvent(new StudentAddedEvent(this, student));
    }

    public Optional<Student> removeStudent(Integer id) {
        return Optional.ofNullable(students.remove(id));
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public void clearStudents() {
        students.clear();
    }
}
