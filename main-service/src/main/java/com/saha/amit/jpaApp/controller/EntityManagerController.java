package com.saha.amit.jpaApp.controller;

import com.github.javafaker.Faker;
import com.saha.amit.jpaApp.dao.AppDAO;
import com.saha.amit.jpaApp.dao.StudentDAO;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.Instructor;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.InstructorDetail;
import com.saha.amit.jpaApp.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("entityManager")
public class EntityManagerController {

    Logger log = LoggerFactory.getLogger(EntityManagerController.class);
    StudentDAO studentDAO;
    AppDAO appDAO;
    private Faker faker;

    @Autowired
    EntityManagerController(Faker faker, StudentDAO studentDAO, AppDAO appDAO) {
        this.faker = faker;
        this.studentDAO = studentDAO;
        this.appDAO = appDAO;
    }

    @GetMapping(value = "student/{operationId}")
    public ResponseEntity studentOperations(@PathVariable int operationId) {

        switch (operationId) {
            case 1:
                Student students = new Student(faker.name().firstName(), faker.name().lastName(), faker.howIMetYourMother().catchPhrase());
                studentDAO.saveStudent(students);
                log.info("Create operation id --> " + operationId + "Student --> " + students.toString());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(students);
            case 2:
                int num = faker.number().numberBetween(1, 10);
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

    @GetMapping(value = "jpaRelations")
    public ResponseEntity jpaRelations(@RequestParam Integer operationId, @RequestParam(required = false) Integer id) {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String email = fName + "@" + lName + ".com";
        Instructor instructor = new Instructor(fName, lName, email);
        InstructorDetail instructorDetail = new InstructorDetail(faker.funnyName().name(), faker.howIMetYourMother().catchPhrase());
        instructor.setInstructorDetail(instructorDetail);

        switch (operationId) {
            case (1):
                //http://localhost:8080/mainService/entityManager/jpaRelations?operationId=1
                appDAO.save(instructor);
                return ResponseEntity.status(HttpStatus.CREATED).body(instructor);
            case 2:
                //http://localhost:8080/mainService/entityManager/jpaRelations?operationId=2
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.getAllInstructors());
            case 3:
                //http://localhost:8080/mainService/entityManager/jpaRelations?operationId=3&id=3
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.findInstructorById(id));
            case 4:
                //http://localhost:8080/mainService/entityManager/jpaRelations?operationId=4&id=3
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted instructor -->"+ appDAO.deleteInstructorById(id));
            case 5:
                //http://localhost:8080/mainService/entityManager/jpaRelations?operationId=5&id=3
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.findInstructorDetailsById(id));
            case 6:
                //http://localhost:8080/mainService/entityManager/jpaRelations?operationId=6&id=5
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.findInstructorDetailsById(id));
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

}
