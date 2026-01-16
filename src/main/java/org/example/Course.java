package org.example;
import java.util.*;

public class Course {
    private String title;
    private Teacher teacher;
    private Set<Student> students = new HashSet<>();

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student findStudent(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Course: " + title + ", teacher=" + teacher;
    }
}
