package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.Instructor;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        //TypedQuery<Instructor> typedQuery = entityManager.createQuery("FROM Instructor ORDER BY id DESC",Instructor.class);
        TypedQuery<Instructor> typedQuery = entityManager.createQuery("FROM Instructor ORDER BY id ASC",Instructor.class);
        return typedQuery.getResultList();
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public Instructor deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
        return tempInstructor;
    }

    @Override
    public InstructorDetail findInstructorDetailsById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    public InstructorDetail deleteInstructorDetailNotInstructorById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        entityManager.remove(tempInstructorDetail);
        return tempInstructorDetail;
    }

}
