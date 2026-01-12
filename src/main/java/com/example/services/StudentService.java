package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student student);

    public Optional<Student> getStudent(int id);

    public List<Student> getStudents();

}
