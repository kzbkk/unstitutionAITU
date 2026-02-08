package org.example.controller;


import org.example.domain.Course;
import org.example.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Course course) {
        service.createCourse(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAllCourses();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public void updateCourse(
            @PathVariable int id,
            @RequestBody Course course
    ) {
        service.updateCourse(id, course);
    }
}