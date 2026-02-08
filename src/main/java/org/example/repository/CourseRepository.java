package org.example.repository;

import org.example.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void save(Course course);

    Optional<Course> findById(int id);

    List<Course> findAll();

    void deleteById(int id);

    void update(int id, Course course);


}