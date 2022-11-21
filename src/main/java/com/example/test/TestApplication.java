package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class TestApplication {


	public static void main(String[] args) {
	//	SpringApplication.run(TestApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(TestApplication.class);

		Employee emp = ctx.getBean(Employee.class);
		Student student = ctx.getBean(Student.class);
		System.out.println(emp.getName1());
		System.out.println(student.toString());



	}

}
