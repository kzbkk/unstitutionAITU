package org.example.repository;

import org.example.domain.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    void save(Student student);

    List<Student> findAll();

    Optional<Student> findById(int id);

    void deleteById(int id);

    void update(int id, Student student);
}