package org.example;

public abstract class Person {
    protected int id;
    protected String name;
    protected String surname;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return id + ": " + name + " " + surname;
    }
}
