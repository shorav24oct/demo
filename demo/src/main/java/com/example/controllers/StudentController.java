package com.example.controllers;

import java.util.List;

import com.example.LazyLoadingBean;
import com.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody StudentRequest studentRequest) {
		Student student = mapper.toEntity(studentRequest);
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents() {
		System.out.println("Current msg is: " + message);
		return ResponseEntity.ok(studentService.getStudents());
	}

}
