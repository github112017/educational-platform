package com.educational.platform.course.enrollments;

import com.educational.platform.course.enrollments.student.create.CreateStudentCommand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents student domain model.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    // for JPA
    private Student() {
    }

    public Student(CreateStudentCommand createStudentCommand) {
        this.username = createStudentCommand.getUsername();
    }

    public String toReference() {
        return username;
    }
}
