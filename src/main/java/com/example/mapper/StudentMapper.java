package com.example.mapper;

import org.mapstruct.Mapper;

import com.example.dto.StudentRequest;
import com.example.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	Student toEntity(StudentRequest request);
}
