package com.example.controllers;

import java.util.List;
import java.util.Optional;

import com.example.LazyLoadingBean;
import com.example.config.MailConfig;
import com.example.exception.StudentNotFoundException;
import com.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.StudentRequest;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.services.StudentServiceImpl;

@RestController
@RequestMapping("/student")
@PropertySource("custom.properties")
public class StudentController {
	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	@Autowired
	private StudentMapper mapper;

	@Autowired
	private LazyLoadingBean lazyLoadingBean;

	@Value("${message}")
	private String message;

	@Autowired
	private MailConfig mailConfig;
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody StudentRequest studentRequest) {
		Student student = mapper.toEntity(studentRequest);
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents() {
		System.out.println("Current msg is: " + message);
		System.out.println("Mail configs are: " + mailConfig);
		return ResponseEntity.ok(studentService.getStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) throws StudentNotFoundException {
		Optional<Student> student = studentService.getStudent(id);

		if (student.isPresent()) {
			return ResponseEntity.ok(student.get());
		}
		else {
			throw new StudentNotFoundException("Student not found for ID: " + id);
		}
	}

	@GetMapping("/idByReq")
	public ResponseEntity<Student> getStudentRequestParam(@RequestParam Integer studentId) {
		return ResponseEntity.ok(studentService.getStudent(studentId).get());
	}

}
