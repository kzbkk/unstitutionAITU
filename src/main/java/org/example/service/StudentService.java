package org.example.service;

import org.example.domain.Student;

import java.util.List;

public interface StudentService {

    void registerStudent(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    void removeStudent(int id);


    default boolean isAdult(Student student) {
        return student.getAge() >= 18;
    }
    void updateStudent(int id, Student student);


}