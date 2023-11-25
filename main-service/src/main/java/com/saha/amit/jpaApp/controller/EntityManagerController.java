package com.saha.amit.jpaApp.controller;

import com.github.javafaker.Faker;
import com.saha.amit.jpaApp.dao.AppDAO;
import com.saha.amit.jpaApp.dao.StudentDAO;
import com.saha.amit.jpaApp.dto.jpaRelations.JPAResponse;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Course;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.Instructor;
import com.saha.amit.jpaApp.dto.jpaRelations.oneToOne.InstructorDetail;
import com.saha.amit.jpaApp.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value = "jpaRelations/oneToOne")
    public ResponseEntity jpaRelationsOneToOne(@RequestParam Integer operationId, @RequestParam(required = false) Integer id) {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String email = fName + "@" + lName + ".com";
        Instructor instructor = new Instructor(fName, lName, email);
        InstructorDetail instructorDetail = new InstructorDetail(faker.funnyName().name(), faker.howIMetYourMother().catchPhrase());
        instructor.setInstructorDetail(instructorDetail);

        switch (operationId) {
            case (1):
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToOne?operationId=1
                appDAO.save(instructor);
                return ResponseEntity.status(HttpStatus.CREATED).body(instructor);
            case 2:
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToOne?operationId=2
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.getAllInstructors());
            case 3:
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToOne?operationId=3&id=3
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.findInstructorById(id));
            case 4:
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToOne?operationId=4&id=3
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted instructor -->" + appDAO.deleteInstructorById(id));
            case 5:
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToOne?operationId=5&id=3
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.findInstructorDetailsById(id));
            case 6:
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToOne?operationId=6&id=5
                return ResponseEntity.status(HttpStatus.FOUND).body(appDAO.findInstructorDetailsById(id));
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @GetMapping(value = "jpaRelations/oneToMany")
    public ResponseEntity jpaRelationsOneToMany(@RequestParam Integer operationId, @RequestParam(required = false) Integer id) {
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String email = fName + "@" + lName + ".com";
        com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor instructor = new com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.Instructor(fName, lName, email);
        com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.InstructorDetail instructorDetail = new com.saha.amit.jpaApp.dto.jpaRelations.oneToMany.InstructorDetail(faker.gameOfThrones().character(), faker.howIMetYourMother().catchPhrase());
        Course course = new Course(faker.funnyName().name());
        Course course2 = new Course(faker.funnyName().name());
        instructor.add(course);
        instructor.add(course2);
        instructor.setInstructorDetail(instructorDetail);
        JPAResponse jpaResponse = new JPAResponse();

        switch (operationId) {
            case (1):
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToMany?operationId=1
                appDAO.saveInstructorOneToMany(instructor);
                jpaResponse.setMsg("Created");
                jpaResponse.setObject(instructor);
                return ResponseEntity.status(HttpStatus.CREATED).body(jpaResponse);
            case (2):
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToMany?operationId=2&id=5
                var ins = appDAO.findInstructorByIdLazy(id);
                //log.info("Instructor: " +ins.getInstructorDetail().toString());
                log.info("the associated courses: " +ins.getCourses().toString());
                jpaResponse.setMsg("Found below Object");
                jpaResponse.setObject(ins);
                return ResponseEntity.status(HttpStatus.CREATED).body(jpaResponse);
            case (3):
                //http://localhost:8080/mainService/entityManager/jpaRelations/oneToMany?operationId=2&id=5
                ins = appDAO.findInstructorByIdLazy(id);
                //log.info("Instructor: " +ins.getInstructorDetail().toString());
                log.info("the associated courses: " +ins.getCourses().toString());
                List<Course> courses1 = appDAO.findCoursesByInstructorId(id);
                ins.setCourses(courses1);
                jpaResponse.setMsg("Found below Object");
                jpaResponse.setObject(ins);
                return ResponseEntity.status(HttpStatus.CREATED).body(jpaResponse);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}


