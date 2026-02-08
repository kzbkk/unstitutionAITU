package org.example.domain;

import java.util.Objects;

public class Student extends Person {

    private int age;
    private Group group;

    public Student(int id, String name, String surname, int age) {
        super(id, name, surname);
        this.age = age;
    }

    // ===== getters =====
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Group getGroup() {
        return group;
    }

    // ===== setter =====
    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}