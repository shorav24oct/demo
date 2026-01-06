package com.example.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@Column(name = "roll_no")
	@Schema(example = "101")
	private Integer rollNo;
	
	@Schema(example = "Shorav")
	private String name;
	
	@Schema(example = "31")
	private Integer age;
}
