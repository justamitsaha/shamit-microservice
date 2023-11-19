package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.Students;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    Logger log = LoggerFactory.getLogger(StudentDAOImpl.class);
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void saveStudent(Students students) {
        entityManager.persist(students);
    }

    @Override
    public Students findStudentById(int id) {
        return entityManager.find(Students.class, id);
    }

    @Override
    public List<Students> getAllStudents() {
        TypedQuery<Students> theQuery = entityManager.createQuery("FROM Students ORDER BY lastName DESC", Students.class);
        List<Students> students = theQuery.getResultList();
        return students;
    }

    @Override
    public List<Students> getStudentByLastName(String lastName) {
        //TypedQuery<Students> theQuery = entityManager.createQuery("FROM Students WHERE lastName = 'Gerhold'", Students.class);
        TypedQuery<Students> theQuery = entityManager.createQuery("FROM Students WHERE lastName=" + lastName, Students.class);
        List<Students> students = theQuery.getResultList();
        return students;
    }

    @Override
    public List<Students> getStudentByLastAndFirstName(String firstName, String lastname) {
        TypedQuery<Students> theQuery = entityManager.createQuery(
                "FROM Students WHERE lastName=:lName OR firstName=:fName", Students.class);
        theQuery.setParameter("lName", lastname);
        theQuery.setParameter("fName", firstName);
        List<Students> students = theQuery.getResultList();
        return students;
    }

    @Override
    public List<Students> getStudentWithLikeOperator(String queryParam) {
        //TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE email LIKE ‘%luv2code.com'", Student.class);
        TypedQuery<Students> theQuery = entityManager.createQuery(
                "FROM Students WHERE email LIKE :param", Students.class);
        theQuery.setParameter("param", queryParam);
        List<Students> students = theQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    public int updateStudent(String newLastName) {
        TypedQuery<Integer> theQuery = (TypedQuery<Integer>) entityManager.createQuery("UPDATE Students SET lastName=:param WHERE email LIKE '%.com'");
        theQuery.setParameter("param", newLastName);
        int numRowsUpdated = theQuery.executeUpdate();
        return numRowsUpdated;
    }

    @Override
    @Transactional
    public void deleteStudent() {
        int id = 8;
        Students theStudent = entityManager.find(Students.class, id);
        //delete all
        //int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate()
        if (theStudent != null)
            entityManager.remove(theStudent);
        else
            log.info("No student found!!");

    }

    @Override
    @Transactional
    public int deleteWithCondition() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Students WHERE lastName='Ritchie'")
                .executeUpdate();
        return numRowsDeleted;
    }

    @Override
    public void createTable() {
        //Mo separate DAo methods needed
        // For create operation this must be added in spring.jpa.hibernate.ddl-auto=create
        //When you run your app, JPA/Hibernate will drop tables then create them
        //If you want to create tables once … and then keep data, use: update
        //spring.jpa.hibernate.ddl-auto=update
        //However, will ALTER database schema based on latest code updates
    }


}
