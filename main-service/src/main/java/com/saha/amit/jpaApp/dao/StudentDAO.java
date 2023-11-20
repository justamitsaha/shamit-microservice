package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.Student;

import java.util.List;

public interface StudentDAO {
    /**
     *
     * @param students Student object with details like first name last and email
     * @return Student object
     */
    public void saveStudent(Student students);
    public Student findStudentById(int id);
    public List<Student> getAllStudents();
    public List<Student> getStudentByLastName(String lastname);
    public List<Student> getStudentByLastAndFirstName(String firstName, String lastname);
    public List<Student> getStudentWithLikeOperator(String queryParam);
    public int updateStudent(String newLastName);
    public void deleteStudent();
    public int deleteWithCondition();
    public void createTable();
}
