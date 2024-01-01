package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Course;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.Instructor;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void saveInstructorOneToMany(com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor instructor) {
        entityManager.persist(instructor);
    }

    public com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor findInstructorByIdLazy(Integer id) {
        return entityManager.find(com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor.class, id);
    }

    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor.class);
        query.setParameter("data", theId);
        com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor instructor = query.getSingleResult();
        return instructor;
    }
}
