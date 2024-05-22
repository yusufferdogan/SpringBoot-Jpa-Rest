package com.example.jpacrud.DAO;

import com.example.jpacrud.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by id", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName = :lastName order by lastName", Student.class);

        return query.setParameter("lastName", lastName).getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        Query query = entityManager.createQuery(
                "UPDATE Student SET firstName = :firstName, lastName = :" +
                        "lastName, email = :email WHERE id = :id");

        System.out.println("Updating student with id " + student.getId());
        System.out.println("query = " + query);

        query.setParameter("id", student.getId());
        query.setParameter("firstName", student.getFirstName());
        query.setParameter("lastName", student.getLastName());
        query.setParameter("email", student.getEmail());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAllStudents() {
        Query query = entityManager.createQuery("DELETE FROM Student");
        query.executeUpdate();
    }
}
