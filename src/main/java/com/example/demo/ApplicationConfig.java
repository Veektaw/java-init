package com.example.demo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    public MySpringClass mySpringClass() {
		return new MySpringClass();
	}
}
