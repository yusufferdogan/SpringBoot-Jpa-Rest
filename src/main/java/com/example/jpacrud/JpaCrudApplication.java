package com.example.jpacrud;

import com.example.jpacrud.DAO.StudentDAO;
import com.example.jpacrud.Entity.Student;
import com.example.jpacrud.Utils.RandomUserGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createMultipleStudents(studentDAO);
            updateStudent(studentDAO);
            getAllStudents(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student");
        Student student = studentDAO.findById(5);
        student.setFirstName("Updated");
        studentDAO.update(student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        System.out.println("Querying for students by last name");
        studentDAO.findByLastName("Moore").forEach(System.out::println);
    }

    private void getAllStudents(StudentDAO studentDAO) {
        System.out.println("Getting all students");
        studentDAO.findAll().forEach(System.out::println);
    }

    private void getStudent(StudentDAO studentDAO) {
        System.out.println("Getting student");
        Student student = studentDAO.findById(1);
        System.out.println("Student found " + student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating student");

        for (int i = 0; i < 15; i++) {
            Student student = new Student(RandomUserGenerator.getRandomName(), RandomUserGenerator.getRandomSurname(), RandomUserGenerator.getRandomEmail());
            studentDAO.save(student);
            System.out.println("Student saved generated id " + student.getId());
        }
    }


    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student");
        Student student = new Student("jonh", "Doe", "jonhDoe@gmail.com");

        System.out.println("Saving student");
        studentDAO.save(student);

        System.out.println("Student saved generated id " + student.getId());
    }

}
