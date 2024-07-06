# Fetching Data Using Spring Data JPA

## Introduction

In this tutorial continuation, we'll explore fetching data using Spring Data JPA. We'll retrieve all records and demonstrate querying based on specific parameters.

### Prerequisites

Ensure your Spring Data JPA project is set up with PostgreSQL configured and populated with sample data.

## Step-by-Step Fetching Data

```java
package com.rohit.student;

import com.rohit.student.model.Student;
import com.rohit.student.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(StudentApplication.class, args);
		Student s1= context.getBean(Student.class);
		Student s2=context.getBean(Student.class);
		Student s3=context.getBean(Student.class);

		StudentRepo repo=context.getBean(StudentRepo.class);

		s1.setRollNo(101);
		s1.setName("Navin");
		s1.setMarks(75);


		s2.setRollNo(102);
		s2.setName("Kiran");
		s2.setMarks(80);


		s3.setRollNo(103);
		s3.setName("Harsh");
		s3.setMarks(70);

		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

		List<Student> s=repo.findAll();

		System.out.println(s);
	}

}

```
