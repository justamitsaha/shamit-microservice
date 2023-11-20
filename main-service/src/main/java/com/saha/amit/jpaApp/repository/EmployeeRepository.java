package com.saha.amit.jpaApp.repository;

import com.saha.amit.jpaApp.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
