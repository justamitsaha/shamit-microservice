package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Course;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.Instructor;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    public List<Instructor> getAllInstructors();
    public Instructor findInstructorById(int theId);
    public Instructor deleteInstructorById(int theId);
    public InstructorDetail findInstructorDetailsById(int theId);
    public InstructorDetail deleteInstructorDetailNotInstructorById(int theId);

    public void saveInstructorOneToMany(com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor instructorDetail);
    public com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor findInstructorByIdLazy(Integer id);
    List<Course> findCoursesByInstructorId(int theId);
}
