package com.students.enrollment.controller;

import com.students.enrollment.dao.StudentDao;
import com.students.enrollment.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentsController {

    //Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam Map<String, String> dataQuery) {


        // TODO validation here.

        return studentDao.findStudent(dataQuery);



    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {

        // TODO validation here.

        return studentDao.createStudent(student);
    }

    @PutMapping("/students")
    public List<Student> updateStudent(@RequestBody Student student) {
        if(student != null && student.getId() > 0) {

            return studentDao.updateStudent(student);

        }


        return studentDao.updateStudent(student);

    }

    @DeleteMapping("/students")

    public Student deleteStudent(@RequestBody Student student) {
        if(student != null && student.getId() > 0) {

            return studentDao.deleteStudent(student);

        }


        return studentDao.deleteStudent(student);

    }




}
