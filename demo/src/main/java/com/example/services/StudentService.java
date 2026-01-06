package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.StudentRequest;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private StudentMapper mapper;
	
	public List<Student> allStudents() {
		return repository.findAll();
	}
	
	public Student saveStudent(StudentRequest studentRequest) {
		Student student = mapper.toEntity(studentRequest);
		
		return repository.save(student);
	}

}
