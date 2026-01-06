package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
	
	@Schema(example = "101")
    private Integer rollNo;

    @Schema(example = "Rahul Sharma")
    private String name;

    @Schema(example = "20")
    private Integer age;

}
