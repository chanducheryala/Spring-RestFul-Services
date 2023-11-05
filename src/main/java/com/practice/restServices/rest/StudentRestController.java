package com.practice.restServices.rest;


import com.practice.restServices.entity.Student;
import com.practice.restServices.exception.StudentErrorResponse;
import com.practice.restServices.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostConstruct
    public void loadStudents() {
       students = new ArrayList<>();
        students.add(new Student("chandu", "ch"));
        students.add(new Student("bhanu", "ch"));
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if((studentId) >= students.size() || studentId < 0)
            throw new StudentNotFoundException("Student not found " + studentId);
        return students.get(studentId);
    }

}
