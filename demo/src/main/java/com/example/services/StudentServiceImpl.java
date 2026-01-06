package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.TestBean;
import com.example.entity.Student;
import com.example.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private TestBean testBean;

	@Override
	public Student addStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Optional<Student> getStudent(int id) {

		return Optional.empty();
	}

	@Override
	public List<Student> getStudents() {
		testBean.method();
		return repository.findAll();
	}

}
