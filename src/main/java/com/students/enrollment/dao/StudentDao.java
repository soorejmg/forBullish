package com.students.enrollment.dao;

import com.students.enrollment.dto.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public List<Student> findAllStudents();
    public Student createStudent(Student student);
    public Student deleteStudent(Student student);

    public List<Student> updateStudent(Student student);
    public List<Student> findStudentByID(int id);
    public List<Student> findStudentByClass(String stud_class);
    public List<Student> findStudent(Map<String, String> dataQuery);


}
