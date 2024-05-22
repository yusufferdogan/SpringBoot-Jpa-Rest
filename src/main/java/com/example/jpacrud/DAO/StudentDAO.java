package com.example.jpacrud.DAO;

import com.example.jpacrud.Entity.Student;

import java.util.List;

public interface StudentDAO {

    //add save method
    public void save(Student student);

    //add find method
    public Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void deleteAllStudents();
}
