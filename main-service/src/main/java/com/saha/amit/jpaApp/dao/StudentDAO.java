package com.saha.amit.jpaApp.dao;

import com.saha.amit.jpaApp.dto.Students;

import javax.transaction.Transactional;

public interface StudentDAO {
    public void saveStudent(Students students);
}
