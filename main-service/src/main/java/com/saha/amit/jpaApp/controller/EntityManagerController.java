package com.saha.amit.jpaApp.controller;

import com.github.javafaker.Faker;
import com.saha.amit.jpaApp.dao.StudentDAO;
import com.saha.amit.jpaApp.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("entityManager")
public class EntityManagerController {

    Logger log = LoggerFactory.getLogger(EntityManagerController.class);
    private Faker faker;
    StudentDAO studentDAO;

    @Autowired
    EntityManagerController(Faker faker, StudentDAO studentDAO){
        this.faker = faker;
        this.studentDAO = studentDAO;
    }

    @GetMapping(value = "student/{operationId}")
    public ResponseEntity studentOperations(@PathVariable int operationId){

        switch (operationId){
            case 1:
                Student students = new Student(faker.name().firstName(),faker.name().lastName(), faker.howIMetYourMother().catchPhrase());
                studentDAO.saveStudent(students);
                log.info("Create operation id --> "+ operationId+ "Student --> "+ students.toString());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(students);
            case 2:
                int num = faker.number().numberBetween(1,10);
                return ResponseEntity.status(HttpStatus.FOUND).body(studentDAO.findStudentById(num));
            case 3:
                return ResponseEntity.status(HttpStatus.FOUND).body(studentDAO.getAllStudents());
            case 4:
                return ResponseEntity.status(HttpStatus.FOUND).body(studentDAO.getStudentByLastName("'Gerhold'"));
            case 5:
                return ResponseEntity.status(HttpStatus.FOUND).body(studentDAO.getStudentByLastAndFirstName("Claretta", "Barrows"));
            case 6:
                return ResponseEntity.status(HttpStatus.FOUND).body(studentDAO.getStudentWithLikeOperator("%.com"));
            case 7:
                return ResponseEntity.status(HttpStatus.FOUND).body(studentDAO.updateStudent("ZHANDU"));
            case 8:
                studentDAO.deleteStudent();
                return ResponseEntity.status(HttpStatus.FOUND).body("LENDU");
            case 9:
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentDAO.deleteWithCondition());

        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

}
