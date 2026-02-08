package org.example.service;

import org.example.domain.Student;
import org.example.exception.NotFoundException;
import org.example.exception.ValidationException;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;


    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerStudent(Student student) {
        if (student.getAge() < 16) {
            throw new ValidationException("Student is too young");
        }
        repository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Student with id " + id + " not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void removeStudent(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        repository.update(id, student);
    }
}