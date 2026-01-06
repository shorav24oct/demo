package com.example.config;

import org.springframework.context.annotation.Bean;

import com.example.beans.TestBean;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	public TestBean testBean() {
		return new TestBean();
	}

}
