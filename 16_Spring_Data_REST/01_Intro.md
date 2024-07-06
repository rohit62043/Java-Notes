# Spring Data REST

## Introduction

In this section, we'll explore Spring Data REST and how it simplifies building RESTful APIs by reducing the amount of boilerplate code. Traditionally, web applications follow a layered architecture: controller, service, and repository. Each layer has specific responsibilities:

- **Controller**: Handles incoming requests and responses.
- **Service**: Contains business logic and processes data.
- **Repository**: Interacts with the database.

### Simplifying with Spring Data REST

#### 1. Understanding the Layers

- **Controller**: Annotated with `@Controller`, handles requests and forwards them to the service layer.
- **Service**: Annotated with `@Service`, contains business logic and interacts with the repository.
- **Repository**: Annotated with `@Repository`, interacts with the database, usually with Spring Data JPA to minimize boilerplate code.

#### 2. Spring Data JPA

Spring Data JPA provides an abstraction over JPA, reducing the need to write custom queries. It allows developers to focus on defining repository interfaces, and Spring Data JPA generates the necessary implementations.

### Introducing Spring Data REST

Spring Data REST takes simplification further by automating the creation of RESTful APIs directly from repository interfaces. This eliminates the need to manually define controller and service layers for basic CRUD operations.

- **Spring Data REST**: Automatically creates endpoints for repositories, handling typical CRUD operations without requiring additional code.

### Hands-On with Spring Data REST

#### 1. Adding Dependencies

To use Spring Data REST, add the necessary dependencies to your `pom.xml` or `build.gradle` file:

```xml
<!-- In pom.xml -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### 2. Creating Repository Interfaces

- Define your repository interfaces as usual:

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods can be defined here if needed
}
```

### 3. Running the Application

- Start your Spring Boot application, and Spring Data REST will automatically expose the repository as RESTful endpoints.

- Example: Student Repository Endpoints
- Spring Data REST provides the following default endpoints:

       - GET /students: Retrieves all students.
       - GET /students/{id}: Retrieves a student by ID.
       - POST /students: Creates a new student.
       - PUT /students/{id}: Updates an existing student.
       = DELETE /students/{id}: Deletes a student by ID.

- Customizing Endpoints
  - If needed, you can customize the endpoints and the exposed data by using annotations such as `@RepositoryRestResource`, `@RestResource`, and `projections`.

## Conclusion

- Spring Data REST simplifies the development of RESTful APIs by automating the creation of endpoints for repository interfaces. This approach minimizes the need for boilerplate code, allowing developers to focus on business logic and data modeling.

- In the next section, we will integrate these features into our job portal application.
