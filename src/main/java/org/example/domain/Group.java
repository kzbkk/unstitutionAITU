package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int id;
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setGroup(this);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}