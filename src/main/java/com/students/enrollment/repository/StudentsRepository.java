package com.students.enrollment.repository;

import com.students.enrollment.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Repository
public class StudentsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from students", new BeanPropertyRowMapper<Student>(Student.class));
    }

    public Student createStudent(Student student) {
        int result = jdbcTemplate.update("insert into students(id, firstName, lastName, className, nationality) values(?, ?, ?, ?, ?)",
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getClassName(),
                student.getNationality()
                );
        return student;
    }

    public Student deleteStudent(Student student) {

        String deleteQuery = "delete from Students where id = '";
        deleteQuery= deleteQuery.concat(Integer.toString(student.getId())).concat("'");

        System.out.println("query to delete is ".concat(deleteQuery));
        int result = jdbcTemplate.update(deleteQuery);
        return student;
    }

    public List<Student> updateStudent(Student student) {



        String _updateQuery = "update Students set";
        String _valueQuery = " values(?";

        if(null != student.getFirstName()) {
            _updateQuery = _updateQuery.concat(" FIRSTNAME='").concat(student.getFirstName()).concat("',");
           // _valueQuery = _valueQuery.concat(",").concat(student.getFirstName());
        }
        if(null != student.getLastName()) {
            _updateQuery = _updateQuery.concat(" LASTNAME='").concat(student.getLastName()).concat("',");
           // _valueQuery = _valueQuery.concat(",").concat(student.getLastName());
        }
        if(null != student.getClassName()) {
            _updateQuery = _updateQuery.concat(" CLASSNAME='").concat(student.getClassName()).concat("',");
           // _valueQuery = _valueQuery.concat(",").concat(student.getClassName());
        }
        if(null != student.getNationality()) {
            _updateQuery = _updateQuery.concat(" NATIONALITY='").concat(student.getNationality()).concat("',");
         //   _valueQuery = _valueQuery.concat(",").concat(student.getNationality());
        }
        _updateQuery=_updateQuery.substring(0, _updateQuery.length() - 1);
        _updateQuery=_updateQuery.concat(" WHERE id=").concat(Integer.toString(student.getId()));

        System.out.println("this is updateQUery".concat(_updateQuery));
        int result = jdbcTemplate.update(_updateQuery);
        return findAll();
    }

    public List<Student> findById(int id) {

        String sql = "SELECT * FROM students WHERE ID = ?";

        return jdbcTemplate.query(sql,new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));

    }

    public List<Student> findByClass(String stud_class) {

        String sql = "SELECT * FROM students WHERE className = ?";

        return jdbcTemplate.query(sql,new Object[]{stud_class}, new BeanPropertyRowMapper<Student>(Student.class));

    }
    //findStudent

    public List<Student> findStudent(Map<String, String> dataQuery) {

        String _query = "SELECT * FROM students where 1=1";

        if(dataQuery.containsKey("id")) {
            _query=_query.concat(" AND ID='").concat(dataQuery.get("id")).concat("'");
        }
        if(dataQuery.containsKey("firstName")) {
            _query=_query.concat(" AND FIRSTNAME='").concat(dataQuery.get("firstName")).concat("'");
        }
        if(dataQuery.containsKey("lastName")) {
            _query=_query.concat(" AND LASTNAME='").concat(dataQuery.get("firstNlastNameame")).concat("'");
        }
        if(dataQuery.containsKey("class")) {
            _query=_query.concat(" AND CLASSNAME='").concat(dataQuery.get("class")).concat("'");
        }
        if(dataQuery.containsKey("nationality")) {
            _query=_query.concat(" AND NATIONALITY='").concat(dataQuery.get("nationality")).concat("'");
        }

        System.out.println("Myaavu");
        System.out.println(_query);

        return jdbcTemplate.query(_query, new BeanPropertyRowMapper<Student>(Student.class));
    }

}
