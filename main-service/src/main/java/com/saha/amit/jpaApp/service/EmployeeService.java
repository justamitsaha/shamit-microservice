package com.saha.amit.jpaApp.service;

import com.saha.amit.jpaApp.dto.Employee;
import com.saha.amit.jpaApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
