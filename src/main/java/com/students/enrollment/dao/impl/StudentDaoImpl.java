package com.students.enrollment.dao.impl;

import com.students.enrollment.dao.StudentDao;
import com.students.enrollment.dto.Student;
import com.students.enrollment.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {


        // TODO generate id

        // TODO add to student object


        return studentsRepository.createStudent(student);
    }


    @Override
    public Student deleteStudent(Student student) {

        return studentsRepository.deleteStudent(student);
    }

    @Override
    public List<Student> updateStudent(Student student) {

        return studentsRepository.updateStudent(student);
    }

    @Override
    public List<Student> findStudentByID(int id){

        return studentsRepository.findById(id);

    }

    @Override
    public List<Student> findStudentByClass(String stud_class){
        return studentsRepository.findByClass(stud_class);

    }

    public List<Student> findStudent(Map<String, String> dataQuery){

        return studentsRepository.findStudent(dataQuery);

    }



}
