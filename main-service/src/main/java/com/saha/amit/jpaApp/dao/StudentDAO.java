package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.Students;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentDAO {
    /**
     *
     * @param students Student object with details like first name last and email
     * @return Student object
     */
    public void saveStudent(Students students);
    public Students findStudentById(int id);
    public List<Students> getAllStudents();
    public List<Students> getStudentByLastName(String lastname);
    public List<Students> getStudentByLastAndFirstName(String firstName, String lastname);
    public List<Students> getStudentWithLikeOperator(String queryParam);
    public int updateStudent(String newLastName);
    public void deleteStudent();
    public int deleteWithCondition();
    public void createTable();
}
