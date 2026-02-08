package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        service.registerStudent(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.removeStudent(id);
    }
    @GetMapping("/{id}/adult")
    public boolean isAdult(@PathVariable int id) {
        Student student = service.getStudentById(id);
        return service.isAdult(student); // ← default method
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable int id,
            @RequestBody Student student
    ) {
        service.updateStudent(id, student);
    }
}