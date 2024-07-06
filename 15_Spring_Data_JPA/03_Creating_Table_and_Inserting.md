# Setting up a Spring Data JPA Project

## Introduction

In this tutorial, we'll set up a Spring Data JPA project to demonstrate how to persist data without manually writing SQL queries. We'll use Hibernate as the underlying ORM framework.

### Prerequisites

Ensure you have PostgreSQL installed and accessible via PG Admin for database management.

## Step-by-Step Setup

### 1. Project Initialization

Navigate to [Spring Initializr](https://start.spring.io/) to create a Maven project:

- Group: `com.telusko`
- Artifact: `spring-data-jpa-example`
- Java: 11 (or your preferred version)
- Dependencies:
  - Spring Data JPA
  - PostgreSQL Driver

### 2. Define the Model Class

Create a `Student` class in the `model` package:

```java
package com.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Integer rollNumber;
    private String name;
    private Integer marks;

    // getters and setters
}
```

### 3. Configure PostgreSQL Connection

- In application.properties, configure your PostgreSQL database connection:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dbName
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Create a Repository Interface

- Define a repository interface StudentRepo extending JpaRepository:

```java
package com.telusko.repository;

import com.telusko.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
```

### 5. Application Logic

- In your main application class, inject StudentRepo and use it to save data:

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

### 6. Run and Verify

- Run your Spring Boot application. Hibernate will automatically create the Student table in your PostgreSQL database if it doesn't exist and insert the student data.

## Conclusion

- With Spring Data JPA, you leverage Hibernate to handle object-relational mapping transparently. No SQL queries are needed for basic CRUD operations, making your code cleaner and more maintainable.

- Next, we'll explore retrieving data using Spring Data JPA. Stay tuned for the next tutorial!
