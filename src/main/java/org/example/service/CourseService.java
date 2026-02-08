package org.example.service;

import org.example.domain.Course;
import java.util.List;

public interface CourseService {

    void createCourse(Course course);

    Course getCourseById(int id);

    List<Course> getAllCourses();

    void deleteCourse(int id);

    void updateCourse(int id, Course course);
}