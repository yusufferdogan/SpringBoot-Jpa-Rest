package com.example.jpacrud.rest;

import com.example.jpacrud.DAO.StudentDAO;
import com.example.jpacrud.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    StudentDAO studentDAO;

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel", "poornimapatel@gmail.com"));
        theStudents.add(new Student("Mario", "Rossi", ""));
        theStudents.add(new Student("Mary", "Smith", ""));
    }

    @Autowired
    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }



    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}
