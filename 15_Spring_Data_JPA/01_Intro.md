# Spring Data JPA Overview

## Introduction

In this section, we'll explore Spring Data JPA. Until now, we've built a job portal application with various layers such as the controller and service layers. While we've handled HTTP requests (GET, POST, PUT, DELETE) and basic operations, we haven't connected to a database yet. This section will focus on completing our application with a database using Spring Data JPA.

## Layer Responsibilities

- **Controller Layer**: Handles incoming requests and responses.
- **Service Layer**: Contains the business logic.
- **Repository Layer**: Connects to the database and handles data operations.

## Connecting to a Database

There are several ways to connect to a database in Spring:

1. **JDBC**: Using standard JDBC.
2. **Spring JDBC**: Simplifies JDBC usage.
3. **Spring ORM**: Requires more manual coding.
4. **Spring Data JPA**: Easiest and most efficient method.

### Why Spring Data JPA?

Spring Data JPA reduces the boilerplate code required for database operations. It abstracts the complexities of JPA (Java Persistence API) and ORM (Object-Relational Mapping) frameworks, making it simpler to perform CRUD (Create, Read, Update, Delete) operations.

## Creating a New Project

To understand how Spring Data JPA works, we will create a new project before integrating it into our existing job portal application. We'll use the student project we discussed earlier when covering Spring JDBC.

### Existing Student Project

- **Dependencies**: Includes Spring Boot JDBC.
- **Database**: Connected to H2 and PostgreSQL.
- **Entities**: Student class with fields `rollno`, `name`, `marks`.
- **Repository**: Uses `JdbcTemplate` for database operations.

### Transition to Spring Data JPA

In the current project, SQL queries are written manually using `JdbcTemplate`. While some developers prefer writing SQL, Spring Data JPA allows us to avoid writing SQL queries directly, making the code cleaner and more maintainable.

## Understanding ORM

Before diving into Spring Data JPA, it's essential to understand the concept of ORM (Object-Relational Mapping). ORM frameworks map Java objects to database tables, allowing developers to interact with the database using Java objects instead of SQL queries.

## Summary

- Spring Data JPA simplifies database operations by abstracting the underlying complexities.
- We'll start with a new project to understand the basics of Spring Data JPA.
- Our existing student project using Spring JDBC will serve as the foundation for this transition.

In the next video, we'll delve deeper into ORM and its relationship with JPA to understand why Spring Data JPA is a powerful tool for database operations in Spring applications.
