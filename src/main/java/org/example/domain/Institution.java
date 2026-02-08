package org.example.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Institution {

    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public Institution(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAdultStudents() {
        return students.stream()
                .filter(Student::isAdult)
                .collect(Collectors.toList());
    }

    public List<Student> sortByAge() {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
    }
}