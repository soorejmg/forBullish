package com.students.enrollment;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.students.enrollment.dao.StudentDao;
import com.students.enrollment.dto.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class StudentsEnrollmentApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	StudentDao studentService;

	@Test
	void testEmptyResult() throws Exception {
		when(studentService.findAllStudents()).thenReturn(new ArrayList<>());

		String expectedJsonBody = "[]";

		this.mvc.perform(get("/students")).andExpect(status().isOk())
				.andExpect(content().json(expectedJsonBody));
	}

	@Test
	void testNonEmptyResult() throws Exception {
		Student s1 = new Student();
		Student s2 = new Student();

		List<Student> list = new ArrayList<>(){{
			add(s1);
			add(s2);
		}};

		when(studentService.findAllStudents()).thenReturn(list);

		String expectedJsonBody = "[{\"id\":0,\"firstName\":null,\"lastName\":null,\"nationality\":null,\"class\":null},{\"id\":0,\"firstName\":null,\"lastName\":null,\"nationality\":null,\"class\":null}]";

		this.mvc.perform(get("/students")).andExpect(status().isOk())
				.andExpect(content().json(expectedJsonBody));
	}
}
