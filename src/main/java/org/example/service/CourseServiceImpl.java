package org.example.service;

import org.example.domain.Course;
import org.example.exception.NotFoundException;
import org.example.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCourse(Course course) {
        repository.save(course);
    }

    @Override
    public Course getCourseById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Course with id " + id + " not found"));
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public void deleteCourse(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateCourse(int id, Course course) {
        repository.update(id, course);
    }
}