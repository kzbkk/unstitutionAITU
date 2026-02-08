package org.example.factory;

import org.example.domain.Student;
import org.example.domain.Teacher;
import org.example.domain.Person;

public class PersonFactory {

    public static Person createStudent(
            int id,
            String name,
            String surname,
            int age
    ) {
        return new Student(id, name, surname, age);
    }

    public static Person createTeacher(
            int id,
            String name,
            String surname,
            String subject
    ) {
        return new Teacher(id, name, surname, subject);
    }
}