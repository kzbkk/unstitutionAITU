package org.example.domain;

import java.util.Objects;

public class Course {

    private int id;
    private String title;
    private String teacherName;

    public Course(int id, String title, String teacherName) {
        this.id = id;
        this.title = title;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{id=" + id +
                ", title='" + title + '\'' +
                ", teacher='" + teacherName + '\'' +
                '}';
    }
}